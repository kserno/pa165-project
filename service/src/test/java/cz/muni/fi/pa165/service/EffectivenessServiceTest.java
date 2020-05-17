package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.effectiveness.EffectivenessDao;
import cz.muni.fi.pa165.entity.Effectiveness;
import cz.muni.fi.pa165.service.config.ServiceConfiguration;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class EffectivenessServiceTest extends AbstractTestNGSpringContextTests {

    @Mock
    private EffectivenessDao effectivenessDao;

    @Autowired
    @InjectMocks
    private EffectivenessService effectivenessService;

    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createEffectiveness_success() {
        Effectiveness effectiveness = new Effectiveness();
        effectivenessService.createEffectiveness(effectiveness);
        verify(effectivenessDao).create(effectiveness);
    }

    @Test
    public void deleteEffectiveness_success() {
        Effectiveness effectiveness = new Effectiveness();
        effectivenessService.deleteEffectiveness(effectiveness);
        verify(effectivenessDao).delete(effectiveness);
    }

    @Test
    public void getEffectivenessById_success() {
        effectivenessService.getEffectivenessById(0L);
        verify(effectivenessDao).retrieve(0L);
    }
}
