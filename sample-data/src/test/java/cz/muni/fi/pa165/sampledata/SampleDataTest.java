package cz.muni.fi.pa165.sampledata;

import cz.muni.fi.pa165.PersistenceApplicationContext;
import cz.muni.fi.pa165.dao.effectiveness.EffectivenessDao;
import cz.muni.fi.pa165.dao.weapon.WeaponDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

@ContextConfiguration(classes = WebsiteSampleDataConfig.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class SampleDataTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SampleDataLoadingFacade sampleDataLoadingFacade;

    @Autowired
    private EffectivenessDao effectivenessDao;
    
    @Autowired
    private WeaponDao weaponDao;
    

    @Test
    public void test_EffectivenessCreated_success() throws IOException {

//        sampleDataLoadingFacade.loadData();

        assertEquals(45, effectivenessDao.retrieveAll().size());
    }

    @Test
    public void test_WeaponEffectiveness() {
        assertEquals(5, weaponDao.retrieve(1L).getWeaponEffectiveness().size());
    }
}
