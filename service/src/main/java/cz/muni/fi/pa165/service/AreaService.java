package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.Area;
import cz.muni.fi.pa165.entity.Creature;

import java.util.List;

/**
 * Service for handling {@link Area}
 *
 *  @author Filip Sollar
 */
public interface AreaService {
    /**
     * Returns all areas
     *
     * @return - list of areas
     */
    List<Area> getAllAreas();

    /**
     * Retrieves area by id
     *
     * @param id - id of area
     * @return area with specified id
     */
    Area getAreaById(Long id);

    /**
     * Deletes area
     *
     * @param area - area to be deleted
     */
    void deleteArea(Area area);

    /**
     * Adds creature to area
     * @param area - area for creatures
     * @param creature - creature to be added
     */
    void addCreatureToArea(Area area, Creature creature);

    /**
     * Removes creature from area
     *
     * @param area - area
     * @param creature - creature to be removed
     */
    void removeCreatureFromArea(Area area, Creature creature);

    /**
     * Updates area
     *
     * @param area - area to be updated
     */
    void updateArea(Area area);

    /**
     * Creates area
     *
     * @param area - area to be created
     */
    void createArea(Area area);
}
