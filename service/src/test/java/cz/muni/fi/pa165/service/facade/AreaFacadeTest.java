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



    /*@Test
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
    }*/




}
