package cz.muni.fi.pa165.service.facade;

import cz.muni.fi.pa165.api.dto.area.AreaCreateDTO;
import cz.muni.fi.pa165.api.dto.area.AreaDTO;
import cz.muni.fi.pa165.api.dto.area.AreaListDTO;
import cz.muni.fi.pa165.api.dto.area.AreaUpdateDTO;
import cz.muni.fi.pa165.api.facade.AreaFacade;
import cz.muni.fi.pa165.dao.area.AreaDao;
import cz.muni.fi.pa165.entity.Area;
import cz.muni.fi.pa165.entity.Creature;
import cz.muni.fi.pa165.service.AreaService;
import cz.muni.fi.pa165.service.BeanMappingService;
import cz.muni.fi.pa165.service.CreatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AreaFacadeImpl implements AreaFacade {

    @Autowired
    private AreaService areaService;

    @Autowired
    private CreatureService creatureService;

    @Autowired
    private BeanMappingService beanMappingService;

    public List<AreaListDTO> getAllAreas() {
        return beanMappingService.mapTo(areaService.getAllAreas(), AreaListDTO.class);
    }

    public AreaDTO getAreaById(Long id) {
        Area area = areaService.getAreaById(id);
        return (area == null) ? null : beanMappingService.mapTo(area, AreaDTO.class);
    }

    @Override
    public Long createArea(AreaCreateDTO areaCreateDTO) {
        Area area = beanMappingService.mapTo(areaCreateDTO, Area.class);
        areaService.createArea(area);
        return area.getId();
    }

    public void deleteArea(Long areaId) {
        areaService.deleteArea(areaService.getAreaById(areaId));
    }

    public void updateArea(AreaUpdateDTO areaUpdateDTO) {
        Area area = beanMappingService.mapTo(areaUpdateDTO, Area.class);
        areaService.updateArea(area);
    }

    public void addCreatureToArea(Long areaId, Long creatureId) {
        Area area = areaService.getAreaById(areaId);
        Creature creature = creatureService.getCreatureById(creatureId);
        areaService.addCreatureToArea(area, creature);
    }

    public void removeCreatureFromArea(Long areaId, Long creatureId) {
        Area area = areaService.getAreaById(areaId);
        Creature creature = creatureService.getCreatureById(creatureId);
        areaService.removeCreatureFromArea(area, creature);
    }

}
