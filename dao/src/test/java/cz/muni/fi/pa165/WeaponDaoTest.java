package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.weapon.WeaponDao;
import cz.muni.fi.pa165.entity.Weapon;
import cz.muni.fi.pa165.enums.AmmunitionType;
import cz.muni.fi.pa165.mock.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class WeaponDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public WeaponDao weaponDao;

    @Test
    public void createWeapon_success_valuesOk() {
        Weapon weapon = Mock.WeaponM.getSCAR();
        weaponDao.create(weapon);

        Weapon weapon2 = weaponDao.retrieve(weapon.getId());

        Assert.assertEquals(weapon, weapon2);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createWeapon_fail_nameNull() {
        Weapon weapon = Mock.WeaponM.getSCAR();
        weapon.setName(null);
        weaponDao.create(weapon);
    }

    @Test
    public void delete_success() {
        Weapon weapon = Mock.WeaponM.getSCAR();
        weaponDao.create(weapon);
        Assert.assertEquals(weapon, weaponDao.retrieve(weapon.getId()));

        weaponDao.delete(weapon);
        Assert.assertNull(weaponDao.retrieve(weapon.getId()));
    }

    @Test
    public void retrieveAll_success() {
        Weapon weapon1 = Mock.WeaponM.getSCAR();
        Weapon weapon2 = Mock.WeaponM.getRocketLauncher();

        weaponDao.create(weapon1);
        weaponDao.create(weapon2);

        Assert.assertEquals(weaponDao.retrieveAll().size(),  2);
        Assert.assertTrue(weaponDao.retrieveAll().contains(weapon1));
        Assert.assertTrue(weaponDao.retrieveAll().contains(weapon2));
    }

    @Test
    public void searchName_success_found() {
        Weapon weapon = Mock.WeaponM.getRocketLauncher();

        weaponDao.create(weapon);
        weaponDao.create(Mock.WeaponM.getSCAR());

        Assert.assertTrue(weaponDao.searchByName(weapon.getName()).contains(weapon));
        Assert.assertEquals(1, weaponDao.searchByName(weapon.getName()).size());
    }

    @Test
    public void searchName_success_notFound() {
        Assert.assertEquals(0, weaponDao.searchByName("SCAR").size());
    }

    @Test
    public void retrieveByAmmunitionType_success_found() {
        weaponDao.create(Mock.WeaponM.getSCAR());
        weaponDao.create(Mock.WeaponM.getRocketLauncher());

        List<Weapon> result = weaponDao.retrieveByAmmunitionType(AmmunitionType.MEDIUM);
        Assert.assertEquals(result.size(), 1);
    }

    @Test
    public void retrieveByAmmunitionType_success_notFound() {
        Assert.assertEquals(0, weaponDao.retrieveByAmmunitionType(AmmunitionType.MEDIUM).size());
    }

    @Test(expectedExceptions = InvalidDataAccessApiUsageException.class)
    public void searchByName_fail_nameNull() {
        weaponDao.searchByName(null);
    }

    @Test(expectedExceptions = InvalidDataAccessApiUsageException.class)
    public void searchByName_fail_nameEmpty() {
        weaponDao.searchByName("");
    }

    @Test(expectedExceptions = InvalidDataAccessApiUsageException.class)
    public void retrieveByAmmunitionType_fail_ammunitionTypeNull() {
        weaponDao.retrieveByAmmunitionType(null);
    }



}
