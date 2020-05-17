package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.area.AreaDao;
import cz.muni.fi.pa165.entity.Area;
import cz.muni.fi.pa165.entity.Creature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Concrete implementation of {@link AreaService}
 *
 * @author Filip Sollar
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Inject
    private AreaDao areaDao;

    public List<Area> getAllAreas() {
        return areaDao.retrieveAll();
    }


    public Area getAreaById(Long id) {
        return areaDao.retrieve(id);
    }

    public void deleteArea(Area area) {
        areaDao.delete(area);
    }

    public void addCreatureToArea(Area area, Creature creature) {
        if (creature.getAreas().contains(area)) {
            throw new IllegalArgumentException("Area already contains creature");
        }
        creature.getAreas().add(area);
    }

    @Override
    public void removeCreatureFromArea(Area area, Creature creature) {
        creature.getAreas().remove(area);
    }

    @Override
    public void updateArea(Area area) {
        areaDao.update(area);
    }

    @Override
    public void createArea(Area area) {
        areaDao.create(area);
    }


}
