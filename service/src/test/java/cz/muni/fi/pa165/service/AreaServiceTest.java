package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.area.AreaDao;
import cz.muni.fi.pa165.entity.Area;
import cz.muni.fi.pa165.entity.Creature;
import cz.muni.fi.pa165.service.config.ServiceConfiguration;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class AreaServiceTest extends AbstractTestNGSpringContextTests {

    @Mock
    private AreaDao areaDao;

    @Autowired
    @InjectMocks
    private AreaService areaService;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createArea_success() {
        Area area = new Area();
        areaService.createArea(area);
        Mockito.verify(areaDao).create(area);
    }

    @Test
    public void updateArea_success() {
        Area area = new Area();
        areaService.updateArea(area);
        Mockito.verify(areaDao).create(area);
    }

    @Test
    public void deleteArea_success() {
        Area area = new Area();
        areaService.deleteArea(area);
        Mockito.verify(areaDao).delete(area);
    }

    @Test
    public void getAreaById_success() {
        areaService.getAreaById(0L);
        Mockito.verify(areaDao).retrieve(anyLong());
    }

    @Test
    public void getAllAreas() {
        areaService.getAllAreas();
        Mockito.verify(areaDao).retrieveAll();
    }

    @Test
    public void addAreaToCreature_success() {
        Area area = mock(Area.class);
        Creature creature = mock(Creature.class);
        when(creature.getAreas()).thenReturn(mock(List.class));

        areaService.addCreatureToArea(area, creature);
        Mockito.verify(creature.getAreas(), times(1)).contains(area);
        Mockito.verify(creature.getAreas(), times(1)).add(area);
    }

    @Test
    public void removeAreaFromCreature_success() {
        Area area = mock(Area.class);
        Creature creature = mock(Creature.class);
        when(creature.getAreas()).thenReturn(mock(List.class));

        areaService.removeCreatureFromArea(area, creature);
        Mockito.verify(creature.getAreas()).remove(area);
    }
}
