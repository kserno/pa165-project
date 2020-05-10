package cz.muni.fi.pa165;

import cz.muni.fi.pa165.dao.user.UserDao;
import cz.muni.fi.pa165.entity.User;
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
public class UserDaoTest extends AbstractTestNGSpringContextTests {


    @Autowired
    public UserDao userDao;

    @Test
    public void createUser_success_valuesOk() {
        User user = Mock.UserM.getUser1();
        userDao.create(user);

        User user2 = userDao.retrieve(user.getId());

        Assert.assertEquals(user, user2);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createUser_fail_nameNull() {
        User user = Mock.UserM.getUser1();
        user.setName(null);
        userDao.create(user);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createUser_fail_usernameNull() {
        User user = Mock.UserM.getUser1();
        user.setUsername(null);
        userDao.create(user);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createUser_fail_passwordNull() {
        User user = Mock.UserM.getUser1();
        user.setPasswordHash(null);
        userDao.create(user);
    }

    @Test(expectedExceptions = ConstraintViolationException.class)
    public void createUser_fail_emailNull() {
        User user = Mock.UserM.getUser1();
        user.setEmail(null);
        userDao.create(user);
    }



    @Test
    public void delete_success() {
        User user = Mock.UserM.getUser1();
        userDao.create(user);
        Assert.assertEquals(user, userDao.retrieve(user.getId()));

        userDao.delete(user);
        Assert.assertNull(userDao.retrieve(user.getId()));
    }

    @Test
    public void retrieveAll_success() {
        User user1 = Mock.UserM.getUser1();
        User user2 = Mock.UserM.getAdmin();

        userDao.create(user1);
        userDao.create(user2);

        Assert.assertEquals(userDao.retrieveAll().size(),  2);
        Assert.assertTrue(userDao.retrieveAll().contains(user1));
        Assert.assertTrue(userDao.retrieveAll().contains(user2));
    }

    @Test
    public void findByEmail_success_found() {
        User user = Mock.UserM.getUser1();
        userDao.create(user);
        Assert.assertEquals(user, userDao.findByEmail("user@user.com"));
    }

    @Test
    public void findByEmail_success_notFound() {
        Assert.assertNull(userDao.findByEmail("user@user.com"));
    }

    @Test
    public void findByUsername_success_found() {
        User user = Mock.UserM.getUser1();
        userDao.create(user);
        Assert.assertEquals(user, userDao.findByUsername(user.getUsername()));
    }

    @Test
    public void findByUsername_success_notFound() {
        Assert.assertNull(userDao.findByUsername("username"));
    }

    @Test
    public void getAdmins_success() {
        User admin = Mock.UserM.getAdmin();
        userDao.create(admin);
        userDao.create(Mock.UserM.getUser1());

        Assert.assertEquals(1, userDao.getAdmins().size());
        Assert.assertTrue(userDao.getAdmins().contains(admin));
    }


}
