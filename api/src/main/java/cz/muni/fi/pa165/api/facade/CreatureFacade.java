package cz.muni.fi.pa165.api.facade;

import cz.muni.fi.pa165.api.dto.creature.*;

import java.util.List;

/**
 * Facade for creature operations
 *
 * @author Filip Sollar
 */
public interface CreatureFacade {
    /**
     * Retrieves all creatures in form of {@link CreatureListDTO}
     * @return list of creatures
     */
    List<CreatureListDTO> getAllCreatures();

    /**
     * Returns creature with specified id or null if not found
     * @param id - id of creature
     * @return Creature in form of {@link CreatureDTO}
     */
    CreatureDTO getCreatureById(Long id);

    /**
     * Creates creature
     * @param creatureCreateDTO - DTO representing created creature
     * @return id of created entity
     */
    Long createCreature(CreatureCreateDTO creatureCreateDTO);

    /**
     * Updates creature with new data
     * @param creatureUpdateDTO - DTO representing changed data
     */
    void updateCreature(CreatureUpdateDTO creatureUpdateDTO);

    /**
     * Deletes the specified creature
     * @param id - id of creature
     */
    void deleteCreature(Long id);

    /**
     * Add area to list of areas where creature can be spotted
     * @param creatureId - id of creature
     * @param areaId - id of area
     */
    void addAreaCreatureSpotted(Long creatureId, Long areaId);

    /**
     * Removes area from list of areas where creature can be spotted
     * @param creatureId - id of creature
     * @param areaId - id of area
     */
    void removeAreaCreatureSpotted(Long creatureId, Long areaId);

    /**
     * Add weapon's effectiveness against creature
     * @param creatureId - id of creature
     * @param creatureEffectivenessCreateDTO - DTO representing Weapon's effectiveness
     */
    void addEffectiveWeapon(Long creatureId, CreatureEffectivenessCreateDTO creatureEffectivenessCreateDTO);

    /**
     * Deletes weapon's effectiveness against creature
     * @param creatureId - id of creature
     * @param effectivenessId - id of effectiveness
     */
    void removeEffectiveWeapon(Long creatureId, Long effectivenessId);
}
