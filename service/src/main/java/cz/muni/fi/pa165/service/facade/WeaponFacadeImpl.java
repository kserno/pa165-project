package cz.muni.fi.pa165.service.facade;

import cz.muni.fi.pa165.api.dto.weapon.*;
import cz.muni.fi.pa165.api.facade.WeaponFacade;
import cz.muni.fi.pa165.dao.weapon.WeaponDao;
import cz.muni.fi.pa165.entity.Creature;
import cz.muni.fi.pa165.entity.Effectiveness;
import cz.muni.fi.pa165.entity.User;
import cz.muni.fi.pa165.entity.Weapon;
import cz.muni.fi.pa165.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Filip Sollar
 */
@Service
@Transactional
public class WeaponFacadeImpl implements WeaponFacade {
    @Autowired
    private WeaponService weaponService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Autowired
    private UserService userService;

    @Autowired
    private CreatureService creatureService;

    @Autowired
    private EffectivenessService effectivenessService;


    public Long createWeapon(WeaponCreateDTO weaponCreateDTO) {
        Weapon weapon = beanMappingService.mapTo(weaponCreateDTO, Weapon.class);
        weaponService.createWeapon(weapon);
        return weapon.getId();
    }

    public void updateWeapon(WeaponUpdateDTO weaponUpdateDTO) {
        Weapon weapon = beanMappingService.mapTo(weaponUpdateDTO, Weapon.class);
        weaponService.updateWeapon(weapon);
    }

    public void deleteWeapon(Long id) {
        Weapon weapon = weaponService.getWeaponById(id);
        weaponService.deleteWeapon(weapon);
    }

    public List<WeaponListDTO> getAllWeapons() {
        return beanMappingService.mapTo(weaponService.getAllWeapons(), WeaponListDTO.class);
    }

    public WeaponDTO getWeaponById(Long id) {
        Weapon weapon = weaponService.getWeaponById(id);
        return (weapon == null) ? null : beanMappingService.mapTo(weapon, WeaponDTO.class);
    }

    public void addWeaponEffectiveness(Long weaponId, WeaponEffectivenessCreateDTO weaponEffectivenessCreateDTO) {
        Weapon weapon = weaponService.getWeaponById(weaponId);
        User author = userService.getUserById(weaponEffectivenessCreateDTO.getUserId());
        Creature creature = creatureService.getCreatureById(weaponEffectivenessCreateDTO.getCreatureId());

        Effectiveness effectiveness = new Effectiveness();

        effectiveness.setWeapon(weapon);
        effectiveness.setCreature(creature);
        effectiveness.setAuthor(author);

        effectivenessService.createEffectiveness(effectiveness);
    }

    public void removeWeaponEffectiveness(Long weaponId, Long effectivenessId) {
        Effectiveness effectiveness = effectivenessService.getEffectivenessById(effectivenessId);

        effectivenessService.deleteEffectiveness(effectiveness);
    }
}
