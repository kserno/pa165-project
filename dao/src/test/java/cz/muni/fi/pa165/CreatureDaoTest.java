package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.creature.CreatureDao;
import cz.muni.fi.pa165.entity.Creature;
import cz.muni.fi.pa165.mock.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolationException;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = PersistenceApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class CreatureDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public CreatureDao creatureDao;

    @Test
    public void createCreature_success_valuesOk() {
        Creature creature = Mock.CreatureM.getGazorpian();
        creatureDao.create(creature);

        Creature creature2 = creatureDao.retrieve(creature.getId());

        Assert.assertEquals(creature, creature2);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createCreature_fail_nameNull() {
        Creature creature = Mock.CreatureM.getGazorpian();
        creature.setName(null);
        creatureDao.create(creature);
    }

    @Test
    public void delete_success() {
        Creature creature = Mock.CreatureM.getZombie();
        creatureDao.create(creature);
        Assert.assertEquals(creature, creatureDao.retrieve(creature.getId()));

        creatureDao.delete(creature);
        Assert.assertNull(creatureDao.retrieve(creature.getId()));
    }

    @Test
    public void retrieveAll_success() {
        Creature creature1 = Mock.CreatureM.getZombie();
        Creature creature2 = Mock.CreatureM.getGazorpian();

        creatureDao.create(creature1);
        creatureDao.create(creature2);

        Assert.assertEquals(creatureDao.retrieveAll().size(),  2);
        Assert.assertTrue(creatureDao.retrieveAll().contains(creature1));
        Assert.assertTrue(creatureDao.retrieveAll().contains(creature2));
    }


}
