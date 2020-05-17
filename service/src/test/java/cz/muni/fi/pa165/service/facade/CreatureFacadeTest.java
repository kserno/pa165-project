package cz.muni.fi.pa165.service.facade;

import cz.muni.fi.pa165.api.dto.creature.CreatureCreateDTO;
import cz.muni.fi.pa165.api.dto.creature.CreatureDTO;
import cz.muni.fi.pa165.api.facade.CreatureFacade;
import cz.muni.fi.pa165.dao.creature.CreatureDao;
import cz.muni.fi.pa165.entity.Creature;
import cz.muni.fi.pa165.service.CreatureService;
import cz.muni.fi.pa165.service.config.ServiceConfiguration;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class CreatureFacadeTest extends AbstractTransactionalTestNGSpringContextTests {

    @Mock
    private CreatureService creatureService;

    @Autowired
    @InjectMocks
    private CreatureFacade creatureFacade;


    @BeforeClass
    public void beforeClass() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createCreature_success() {
        CreatureCreateDTO dto = getCreateCreature();

        creatureFacade.createCreature(dto);

        /*ArgumentCaptor<Creature> capture = ArgumentCaptor.forClass(Creature.class);

        verify(creatureService).createCreature(capture.capture());
        Assert.assertEquals(capture.getValue().getName(), dto.getName());*/
    }

    @Test
    public void getCreatureById_success() {
        CreatureCreateDTO dto = getCreateCreature();

        Long id = creatureFacade.createCreature(dto);
        //CreatureDTO creatureDTO = creatureFacade.getCreatureById(id);

        /*verify(creatureService).createCreature(any(Creature.class));
        verify(creatureService).getCreatureById(id);

        Assert.assertEquals(creatureDTO.getName(), dto.getName());*/
    }

    @Test
    public void updateCreature_success() {
//        CreatureCreateDTO dto = new CreatureCreateDTO();

        //Long id = creatureFacade.createCreature(dto);



    }

    private static CreatureCreateDTO getCreateCreature(){
        CreatureCreateDTO dto = new CreatureCreateDTO();

        dto.setName("Creature");

        dto.setAgility(20);
        dto.setHeight(180);
        dto.setWeight(80);

        return dto;
    }

}
