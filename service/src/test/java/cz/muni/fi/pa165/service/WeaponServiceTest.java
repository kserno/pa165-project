package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.weapon.WeaponDao;
import cz.muni.fi.pa165.entity.Weapon;
import cz.muni.fi.pa165.service.config.ServiceConfiguration;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class WeaponServiceTest {

    @Autowired
    @InjectMocks
    private WeaponService weaponService;

    @Mock
    private WeaponDao weaponDao;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void weaponCreate_success() {
        Weapon weapon = new Weapon();
        weaponService.createWeapon(weapon);
        verify(weaponDao).create(weapon);
    }

    @Test
    public void weaponUpdate_success() {
        Weapon weapon = new Weapon();
        weaponService.updateWeapon(weapon);
        verify(weaponDao).update(weapon);
    }

    @Test
    public void weaponDelete_success() {
        Weapon weapon = new Weapon();
        weaponService.deleteWeapon(weapon);
        verify(weaponDao).delete(weapon);
    }




}
