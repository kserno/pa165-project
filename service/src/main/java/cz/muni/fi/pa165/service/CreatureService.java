package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Area;
import cz.muni.fi.pa165.entity.Creature;

import java.util.List;

/**
 * Service interface for {@link Creature}
 *
 * @author Filip Sollar
 */
public interface CreatureService {
    /**
     * Returns creature associated with id
     * @param id - id of specified creature
     * @return Creature with matching id
     */
    Creature getCreatureById(Long id);

    /**
     * Returns all creatures
     *
     * @return all creatures from db
     */
    List<Creature> getAllCreatures();

    /**
     * Creates creature
     *
     * @param creature - creature to be created
     */
    void createCreature(Creature creature);

    /**
     * Deletes cretures
     *
     * @param creature - creature to be deleted
     */
    void deleteCreature(Creature creature);

    /**
     * Updated creature with new data
     *
     * @param creature - creature containing new data
     */
    void updateCreature(Creature creature);

    /**
     * Adds creature to area
     *
     * @param creature - creature to be added to area
     * @param area - area where
     */
    void addCreatureToArea(Creature creature, Area area);

    /**
     * Removes creature from area
     *
     * @param creature - creature
     * @param area - area
     */
    void removeCreatureFromArea(Creature creature, Area area);
}
