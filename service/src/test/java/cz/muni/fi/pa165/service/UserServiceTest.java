package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.user.UserDao;
import cz.muni.fi.pa165.entity.User;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class UserServiceTest extends AbstractTestNGSpringContextTests {

    @Mock
    private UserDao userDao;

    @Autowired
    @InjectMocks
    private UserService userService;


    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void createUser_success() {
        User user = new User();

        userService.registerUser(user, "");
        verify(userDao).create(any(User.class));
    }

    @Test
    public void getAllUsers_success() {
        userService.getAllUsers();
        verify(userDao).retrieveAll();
    }

    @Test
    public void getUserById_success() {
        userService.getUserById(0L);
        verify(userDao).retrieve(0L);
    }


}
