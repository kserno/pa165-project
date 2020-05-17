package cz.muni.fi.pa165.service.facade;

import cz.muni.fi.pa165.api.dto.user.UserAuthenticateDTO;
import cz.muni.fi.pa165.api.dto.user.UserChangeImageDTO;
import cz.muni.fi.pa165.api.dto.user.UserDTO;
import cz.muni.fi.pa165.api.dto.user.UserRegisterDTO;
import cz.muni.fi.pa165.api.facade.UserFacade;
import cz.muni.fi.pa165.dao.user.UserDao;
import cz.muni.fi.pa165.service.config.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Filip Sollar
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class UserFacadeTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserFacade userFacade;

    private Long user1Id;


    @BeforeMethod
    public void setUp() {
        UserRegisterDTO dto = getRegisterTestUser();
        user1Id = userFacade.registerUser(dto);
    }
/*
    @Test
    public void registerUser_success() {
        Assert.assertNotNull(userFacade.findUserById(user1Id));
    }

    @Test
    public void authenticate_success() {

        UserAuthenticateDTO authenticateDto = new UserAuthenticateDTO();

        authenticateDto.setEmail(getRegisterTestUser().getEmail());
        authenticateDto.setPassword(getRegisterTestUser().getPassword());

        Assert.assertTrue(userFacade.authenticate(authenticateDto));
    }

    @Test
    public void changeImage_success() {


        UserChangeImageDTO changeImageDTO = new UserChangeImageDTO();

        changeImageDTO.setUserId(user1Id);
        changeImageDTO.setImage(new byte[0]);
        changeImageDTO.setImageMimeType("jpeg");

        userFacade.changeUserImage(changeImageDTO);

        UserDTO userDTO = userFacade.findUserById(user1Id);

        Assert.assertEquals(userDTO.getImageMimeType(), changeImageDTO.getImageMimeType());
        Assert.assertEquals(userDTO.getImage(), changeImageDTO.getImage());
    }

    /*
    @Test
    public void usernameExists_success() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(getRegisterTestUser().getUsername());

        Assert.assertTrue(userFacade.usernameExists(userDTO));
    }

    @Test
    public void emailExists_success() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(getRegisterTestUser().getEmail());

        Assert.assertTrue(userFacade.emailExists(userDTO));
    }*/

    private static UserRegisterDTO getRegisterTestUser() {
        UserRegisterDTO dto = new UserRegisterDTO();

        dto.setEmail("test@test.com");
        dto.setName("Testovaci pouzivatel");
        dto.setPassword("passw");
        dto.setUsername("test_user");

        return dto;
    }
}
