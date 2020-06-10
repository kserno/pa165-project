package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.creature.CreatureDao;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class CreatureServiceTest extends AbstractTestNGSpringContextTests {

    @Mock
    private CreatureDao creatureDao;

    @InjectMocks
    @Autowired
    private CreatureService creatureService;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createCreature_success() {
        Creature creature = new Creature();
        creatureService.createCreature(creature);
        verify(creatureDao).create(creature);
    }

    @Test
    public void updateCreature_success() {
        Creature creature = new Creature();
        creatureService.updateCreature(creature);
        verify(creatureDao).update(creature);
    }

    @Test
    public void getCreatureById_success() {
        creatureService.getCreatureById(0L);
        verify(creatureDao).retrieve(0L);
    }

    @Test
    public void getAllCreatures_success() {
        creatureService.getAllCreatures();
        verify(creatureDao).retrieveAll();
    }

    @Test
    public void deleteCreature_success() {
        Creature creature = new Creature();
        creatureService.deleteCreature(creature);
        verify(creatureDao).delete(creature);
    }

    @Test
    public void addAreaToCreature_success() {
        Area area = mock(Area.class);
        Creature creature = mock(Creature.class);
        when(creature.getAreas()).thenReturn(mock(List.class));

        creatureService.addCreatureToArea(creature, area);
        Mockito.verify(creature.getAreas(), times(1)).add(area);
    }

    @Test
    public void removeAreaFromCreature_success() {
        Area area = mock(Area.class);
        Creature creature = mock(Creature.class);
        when(creature.getAreas()).thenReturn(mock(List.class));

        creatureService.removeCreatureFromArea(creature, area);
        Mockito.verify(creature.getAreas()).remove(area);
    }
}
