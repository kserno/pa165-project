package cz.muni.fi.pa165.service.facade;

import cz.muni.fi.pa165.api.facade.WeaponFacade;
import cz.muni.fi.pa165.dao.weapon.WeaponDao;
import cz.muni.fi.pa165.service.config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class WeaponFacadeTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WeaponFacade weaponFacade;

    @Autowired
    private WeaponDao weaponDao;

    @Test
    public void createWeapon_success() {
        /*weaponFacade.createWeapon();
        weaponFacade.deleteWeapon();
        weaponFacade.addWeaponEffectiveness();

        weaponFacade.updateWeapon();
        weaponFacade.getAllWeapons();
        weaponFacade.getWeaponById();
        weaponFacade.removeWeaponEffectiveness();*/
    }

    @Test
    public void getWeaponById_success() {
    }


    @Test
    public void deleteWeapon_success() {

    }



    @Test
    public void updateWeapon_success() {
    }

    @Test
    public void getAllWeapons_success() {
    }


    @Test
    public void addWeaponEffectiveness_success() {

    }

    @Test
    public void removeWeaponEffectiveness_success() {
    }


}
