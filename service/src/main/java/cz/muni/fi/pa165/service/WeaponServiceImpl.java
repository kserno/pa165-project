package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.effectiveness.EffectivenessDao;
import cz.muni.fi.pa165.dao.weapon.WeaponDao;
import cz.muni.fi.pa165.entity.Weapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Concrete implementation of {@link WeaponService}
 *
 * @author Filip Sollar
 */
@Service
public class WeaponServiceImpl implements WeaponService {


    private Logger logger = Logger.getGlobal();
    @Inject
    private WeaponDao weaponDao;

    @Autowired
    private EffectivenessDao effectivenessDao;

    @Override
    public Weapon getWeaponById(Long id) {
        return weaponDao.retrieve(id);
    }

    @Override
    public void createWeapon(Weapon weapon) {
        weaponDao.create(weapon);
    }

    @Override
    public void updateWeapon(Weapon weapon) {
        weaponDao.update(weapon);
    }

    @Override
    public void deleteWeapon(Weapon weapon) {
        weaponDao.delete(weapon);
    }

    @Override
    public List<Weapon> getAllWeapons() {
        return weaponDao.retrieveAll();
    }
}
