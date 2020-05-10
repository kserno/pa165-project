package cz.muni.fi.pa165.dao.weapon;

import cz.muni.fi.pa165.dao.BaseDao;
import cz.muni.fi.pa165.entity.Weapon;
import cz.muni.fi.pa165.enums.AmmunitionType;

import java.util.List;

/**
 * Dao for operation on {@link Weapon} entity
 *
 * @author Filip Sollar
 */
public interface WeaponDao extends BaseDao<Weapon> {
    List<Weapon> searchByName(String name);
    List<Weapon> retrieveByAmmunitionType(AmmunitionType ammunitionType);
}
