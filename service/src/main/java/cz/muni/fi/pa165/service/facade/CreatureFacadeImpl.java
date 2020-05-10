package cz.muni.fi.pa165.service.facade;

import cz.muni.fi.pa165.api.dto.creature.*;
import cz.muni.fi.pa165.api.facade.CreatureFacade;
import cz.muni.fi.pa165.entity.*;
import cz.muni.fi.pa165.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Filip Sollar
 */
@Service
@Transactional
public class CreatureFacadeImpl implements CreatureFacade {

    @Inject
    private CreatureService creatureService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private BeanMappingService beanMappingService;

    @Autowired
    private EffectivenessService effectivenessService;

    @Autowired
    private UserService userService;

    @Autowired
    private WeaponService weaponService;


    public List<CreatureListDTO> getAllCreatures() {
        return beanMappingService.mapTo(creatureService.getAllCreatures(), CreatureListDTO.class);
    }

    public CreatureDTO getCreatureById(Long id) {
        Creature creature = creatureService.getCreatureById(id);
        return (creature == null) ? null : beanMappingService.mapTo(creature, CreatureDTO.class);
    }

    public Long createCreature(CreatureCreateDTO creatureCreateDTO) {
        Creature creature = beanMappingService.mapTo(creatureCreateDTO, Creature.class);
        creatureService.createCreature(creature);
        return creature.getId();
    }

    public void updateCreature(CreatureUpdateDTO creatureUpdateDTO) {
        Creature creature = beanMappingService.mapTo(creatureUpdateDTO, Creature.class);
        creatureService.updateCreature(creature);
    }

    public void deleteCreature(Long id) {
        Creature creature = creatureService.getCreatureById(id);
        creatureService.deleteCreature(creature);
    }

    public void addAreaCreatureSpotted(Long creatureId, Long areaId) {
        Creature creature = creatureService.getCreatureById(creatureId);
        Area area = areaService.getAreaById(areaId);
        creatureService.addCreatureToArea(creature, area);
    }

    public void removeAreaCreatureSpotted(Long creatureId, Long areaId) {
        Creature creature = creatureService.getCreatureById(creatureId);
        Area area = areaService.getAreaById(areaId);
        creatureService.removeCreatureFromArea(creature, area);
    }

    public void addEffectiveWeapon(Long creatureId, CreatureEffectivenessCreateDTO creatureEffectivenessCreateDTO) {
        Effectiveness effectiveness = new Effectiveness();

        User author = userService.getUserById(creatureEffectivenessCreateDTO.getUserId());
        Weapon weapon = weaponService.getWeaponById(creatureEffectivenessCreateDTO.getWeaponId());
        Creature creature = creatureService.getCreatureById(creatureId);

        effectiveness.setAuthor(author);
        effectiveness.setWeapon(weapon);
        effectiveness.setCreature(creature);
        effectiveness.setRating(creatureEffectivenessCreateDTO.getRating());

        effectivenessService.createEffectiveness(effectiveness);
    }

    public void removeEffectiveWeapon(Long creatureId, Long effectivenessId) {
        Creature creature = creatureService.getCreatureById(creatureId);
        Effectiveness effectiveness = effectivenessService.getEffectivenessById(effectivenessId);

        effectivenessService.deleteEffectiveness(effectiveness);
    }


}
