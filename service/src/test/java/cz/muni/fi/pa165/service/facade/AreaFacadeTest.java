package cz.muni.fi.pa165.service.facade;

import cz.muni.fi.pa165.api.dto.area.AreaCreateDTO;
import cz.muni.fi.pa165.api.dto.area.AreaDTO;
import cz.muni.fi.pa165.api.dto.area.AreaListDTO;
import cz.muni.fi.pa165.api.dto.area.AreaUpdateDTO;
import cz.muni.fi.pa165.api.facade.AreaFacade;
import cz.muni.fi.pa165.dao.area.AreaDao;
import cz.muni.fi.pa165.dao.creature.CreatureDao;
import cz.muni.fi.pa165.entity.Area;
import cz.muni.fi.pa165.entity.Creature;
import cz.muni.fi.pa165.service.config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class AreaFacadeTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private AreaFacade areaFacade;

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private CreatureDao creatureDao;


    @Test
    public void createArea_success() {
        AreaCreateDTO dto = new AreaCreateDTO();

        dto.setImage(null);
        dto.setName("Test");
        dto.setDescription("test");

        areaFacade.createArea(dto);

        List<AreaListDTO> areas = areaFacade.getAllAreas();
        Assert.assertEquals(1, areas.size());

        AreaListDTO area = areas.get(0);

        Assert.assertEquals(area.getName(), dto.getName());
        Assert.assertEquals(area.getDescription(), dto.getDescription());
        Assert.assertEquals(area.getImage(), dto.getImage());
    }

    @Test
    public void getAllAreas_success() {
        Area area1 = new Area();
        area1.setName("title1");
        area1.setDescription("desc1");

        Area area2 = new Area();
        area2.setName("title2");
        area2.setDescription("desc2");

        areaDao.create(area1);
        areaDao.create(area2);

        Assert.assertEquals(2, areaDao.retrieveAll().size());
    }

    @Test
    public void deleteArea_success() {
        Area area1 = new Area();
        area1.setName("title1");
        area1.setDescription("desc1");
        areaDao.create(area1);

        areaFacade.deleteArea(area1.getId());
        
        Assert.assertEquals(0, areaFacade.getAllAreas().size());
    }

    @Test
    public void getAreaById_success() {
        Area area = new Area();
        area.setName("title");
        area.setDescription("description");
        areaDao.create(area);

        AreaDTO dto = areaFacade.getAreaById(area.getId());

        Assert.assertEquals(area.getId(), dto.getId());
        Assert.assertEquals(area.getName(), dto.getName());
        Assert.assertEquals(area.getDescription(), dto.getDescription());
        Assert.assertEquals(area.getImage(), dto.getImage());
    }

    @Test
    public void updateArea_success() {
        Area area = new Area();
        area.setName("title");
        area.setDescription("description");
        areaDao.create(area);

        AreaUpdateDTO areaUpdateDTO = new AreaUpdateDTO();

        areaUpdateDTO.setId(area.getId());
        areaUpdateDTO.setDescription("Description123");
        areaUpdateDTO.setName("Title");

        areaFacade.updateArea(areaUpdateDTO);
        AreaDTO dto = areaFacade.getAreaById(area.getId());

        Assert.assertEquals(areaUpdateDTO.getName(), dto.getName());
        Assert.assertEquals(areaUpdateDTO.getDescription(), dto.getDescription());
        Assert.assertEquals(areaUpdateDTO.getImage(), dto.getImage());
    }

    @Test
    public void addCreatureToArea_success() {
        Creature creature = new Creature();

        creature.setName("Zombie");
        creature.setAgility(10);
        creature.setWeight(80);
        creature.setHeight(180);

        creatureDao.create(creature);

        Area area = new Area();
        area.setName("Area");
        area.setDescription("description");
        areaDao.create(area);

        areaFacade.addCreatureToArea(area.getId(), creature.getId());
        AreaDTO dto = areaFacade.getAreaById(area.getId());

        Assert.assertEquals(1, dto.getCreatures().size());
        Assert.assertEquals(creature.getId(), dto.getCreatures().get(0).getId());
    }

    @Test
    public void removeCreatureFromArea_success() {
        Creature creature = new Creature();

        creature.setName("Zombie");
        creature.setAgility(10);
        creature.setWeight(80);
        creature.setHeight(180);

        creatureDao.create(creature);

        Area area = new Area();
        area.setName("Area");
        area.setDescription("description");
        areaDao.create(area);

        areaFacade.addCreatureToArea(area.getId(), creature.getId());
        AreaDTO dto = areaFacade.getAreaById(area.getId());

        Assert.assertEquals(1, dto.getCreatures().size());

        areaFacade.removeCreatureFromArea(area.getId(), creature.getId());

        dto = areaFacade.getAreaById(area.getId());

        Assert.assertEquals(0, dto.getCreatures().size());
    }
}
