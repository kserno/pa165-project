package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.area.AreaDao;
import cz.muni.fi.pa165.entity.Area;
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
public class AreaDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public AreaDao areaDao;


    @Test
    public void createArea_success_valuesOk() {
        Area area = Mock.AreaM.getArea1Correct();
        areaDao.create(area);
        Area area2 = areaDao.retrieve(area.getId());

        Assert.assertEquals(area, area2);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createArea_fail_nameNull() {
        Area area = Mock.AreaM.getArea1Correct();
        area.setName(null);
        areaDao.create(area);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createArea_fail_descriptionNull() {
        Area area = Mock.AreaM.getArea1Correct();
        area.setDescription(null);
        areaDao.create(area);
    }

    @Test
    public void updateArea_success_valuesOk() {
        Area area = Mock.AreaM.getArea1Correct();
        areaDao.create(area);

        area.setName("Changed Name");
        areaDao.update(area);

        Assert.assertEquals(area, areaDao.retrieve(area.getId()));
    }

    /*@Test//(expectedExceptions = ConstraintViolationException.class)
    public void updateArea_fail_nameNull() {
        Area area = getArea1Correct();
        areaDao.create(area);

        area.setName(null);
        areaDao.update(area);
    }

    @Test//(expectedExceptions = ConstraintViolationException.class)
    public void updateArea_fail_descriptionNull() {
        Area area = getArea1Correct();
        areaDao.create(area);

        area.setDescription(null);
        areaDao.update(area);
    }*/

    @Test
    public void deleteArea_success() {
        Area area = Mock.AreaM.getArea1Correct();
        areaDao.create(area);
        Assert.assertEquals(area, areaDao.retrieve(area.getId()));

        areaDao.delete(area);
        Assert.assertNull(areaDao.retrieve(area.getId()));
    }

    @Test
    public void retrieveAll_success() {
        Area area1 = Mock.AreaM.getArea1Correct();
        Area area2 = Mock.AreaM.getArea52Correct();

        areaDao.create(area1);
        areaDao.create(area2);

        Assert.assertEquals(areaDao.retrieveAll().size(),  2);
        Assert.assertTrue(areaDao.retrieveAll().contains(area1));
        Assert.assertTrue(areaDao.retrieveAll().contains(area2));
    }

    @Test
    public void searchByName_success() {
        areaDao.create(Mock.AreaM.getArea1Correct());
        areaDao.create(Mock.AreaM.getArea52Correct());

        Assert.assertEquals(areaDao.searchByName("Area 52").size(), 1);
    }


}
