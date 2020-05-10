package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.creature.CreatureDao;
import cz.muni.fi.pa165.dao.effectiveness.EffectivenessDao;
import cz.muni.fi.pa165.dao.user.UserDao;
import cz.muni.fi.pa165.dao.weapon.WeaponDao;
import cz.muni.fi.pa165.entity.Effectiveness;
import cz.muni.fi.pa165.mock.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class EffectivenessDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private EffectivenessDao weaponEffectivenessDao;

    @Autowired
    private WeaponDao weaponDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CreatureDao creatureDao;


    @BeforeMethod
    public void setUp() {
        userDao.create(Mock.UserM.getUser1());
        weaponDao.create(Mock.WeaponM.getSCAR());
        weaponDao.create(Mock.WeaponM.getRocketLauncher());
        creatureDao.create(Mock.CreatureM.getZombie());
        creatureDao.create(Mock.CreatureM.getGazorpian());
    }

    @Test
    public void createWeaponEffectiveness_success_valuesOk() {
        Effectiveness weaponEffectiveness = getScarZombieEffectiveness();
        weaponEffectivenessDao.create(weaponEffectiveness);

        Effectiveness weaponEffectiveness2 = weaponEffectivenessDao.retrieve(weaponEffectiveness.getId());

        Assert.assertEquals(weaponEffectiveness, weaponEffectiveness2);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createWeaponEffectiveness_fail_authorNull() {
        Effectiveness weaponEffectiveness = getScarGazorpianEffectiveness();
        weaponEffectiveness.setAuthor(null);
        weaponEffectivenessDao.create(weaponEffectiveness);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createWeaponEffectiveness_fail_Null() {
        Effectiveness weaponEffectiveness = getScarGazorpianEffectiveness();
        weaponEffectiveness.setAuthor(null);
        weaponEffectivenessDao.create(weaponEffectiveness);
    }

    @Test
    public void delete_success() {
        Effectiveness weaponEffectiveness = getScarGazorpianEffectiveness();
        weaponEffectivenessDao.create(weaponEffectiveness);
        Assert.assertEquals(weaponEffectiveness, weaponEffectivenessDao.retrieve(weaponEffectiveness.getId()));

        weaponEffectivenessDao.delete(weaponEffectiveness);
        Assert.assertNull(weaponEffectivenessDao.retrieve(weaponEffectiveness.getId()));
    }

    @Test
    public void retrieveAll_success() {
        Effectiveness weaponEffectiveness1 = getScarGazorpianEffectiveness();
        Effectiveness weaponEffectiveness2 = getScarZombieEffectiveness();

        weaponEffectivenessDao.create(weaponEffectiveness1);
        weaponEffectivenessDao.create(weaponEffectiveness2);

        Assert.assertEquals(weaponEffectivenessDao.retrieveAll().size(),  2);
        Assert.assertTrue(weaponEffectivenessDao.retrieveAll().contains(weaponEffectiveness1));
        Assert.assertTrue(weaponEffectivenessDao.retrieveAll().contains(weaponEffectiveness2));
    }

    private Effectiveness getScarZombieEffectiveness() {
        Effectiveness weaponEffectiveness = new Effectiveness();

        weaponEffectiveness.setAuthor(userDao.findByEmail("user@user.com"));
        weaponEffectiveness.setCreature(creatureDao.searchByName("Zombie").get(0));
        weaponEffectiveness.setWeapon(weaponDao.searchByName("SCAR").get(0));
        weaponEffectiveness.setRating(10);

        return weaponEffectiveness;
    }

    private Effectiveness getScarGazorpianEffectiveness() {
        Effectiveness weaponEffectiveness = new Effectiveness();

        weaponEffectiveness.setAuthor(userDao.findByEmail("user@user.com"));
        weaponEffectiveness.setCreature(creatureDao.searchByName("Gazorpian").get(0));
        weaponEffectiveness.setWeapon(weaponDao.searchByName("SCAR").get(0));
        weaponEffectiveness.setRating(1);

        return weaponEffectiveness;
    }

    private Effectiveness getRocketLauncherGazorpianEffectiveness() {
        Effectiveness weaponEffectiveness = new Effectiveness();

        weaponEffectiveness.setAuthor(userDao.findByEmail("user@user.com"));
        weaponEffectiveness.setCreature(creatureDao.searchByName("Gazorpian").get(0));
        weaponEffectiveness.setWeapon(weaponDao.searchByName("Rocket launcher").get(0));
        weaponEffectiveness.setRating(10);

        return weaponEffectiveness;
    }
}
