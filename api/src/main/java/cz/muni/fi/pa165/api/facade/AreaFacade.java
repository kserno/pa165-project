package cz.muni.fi.pa165.api.facade;

import cz.muni.fi.pa165.api.dto.area.AreaCreateDTO;
import cz.muni.fi.pa165.api.dto.area.AreaDTO;
import cz.muni.fi.pa165.api.dto.area.AreaListDTO;
import cz.muni.fi.pa165.api.dto.area.AreaUpdateDTO;

import java.util.List;

/**
 * Facade for areas
 */
public interface AreaFacade {
    /**
     * Retrieves all areas
     * @return all areas represented in form of {@link AreaListDTO}
     */
    List<AreaListDTO> getAllAreas();
//    List<AreaListDTO> getAllAreasWithCreature(Long creatureId);

    /**
     * Returns area with specified id in form of {@link AreaDTO}
     * @param id - id of requested area
     * @return area with id or null
     */
    AreaDTO getAreaById(Long id);

    /**
     * Creates area
     * @param areaCreateDTO - DTO representing created area
     * @return id of created entity
     */
    Long createArea(AreaCreateDTO areaCreateDTO);

    /**
     * Deletes the specified area
     * @param areaId - id of area to be deleted
     */
    void deleteArea(Long areaId);

    /**
     * Updates area
     * @param areaUpdateDTO - DTO representing changes to area
     */
    void updateArea(AreaUpdateDTO areaUpdateDTO);

    /**
     * Adds creature with id to specified area
     * @param areaId - idea of selected area
     * @param creatureId - id of creature to be inserted
     */
    void addCreatureToArea(Long areaId, Long creatureId);

    /**
     * Removes creature from the specified area
     * @param areaId - id of area
     * @param creatureId - id of creature
     */
    void removeCreatureFromArea(Long areaId, Long creatureId);
}
