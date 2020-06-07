package cz.muni.fi.pa165.service.facade;

import cz.muni.fi.pa165.api.dto.user.*;
import cz.muni.fi.pa165.api.facade.UserFacade;
import cz.muni.fi.pa165.dao.user.UserDao;
import cz.muni.fi.pa165.entity.User;
import cz.muni.fi.pa165.service.BeanMappingService;
import cz.muni.fi.pa165.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Filip Sollar
 */
@Transactional
@Service
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private BeanMappingService beanMappingService;


    public Long registerUser(UserRegisterDTO userRegisterDTO) {
        User user = beanMappingService.mapTo(userRegisterDTO, User.class);
        userService.registerUser(user, userRegisterDTO.getPassword());
        return user.getId();
    }

    public UserDTO findUserById(Long id) {
        User user = userService.getUserById(id);
        return (user == null) ? null : beanMappingService.mapTo(user, UserDTO.class);
    }

    public UserDTO findUserByEmail(String email) {
        User user = userService.findUserByEmail(email);
        return (user == null) ? null : beanMappingService.mapTo(user, UserDTO.class);
    }

    public List<UserListDTO> getAllUsers() {
        return beanMappingService.mapTo(userService.getAllUsers(), UserListDTO.class);
    }

    public List<UserListDTO> getAdmins() {
        return beanMappingService.mapTo(userService.getAdmins(), UserListDTO.class);
    }

    public boolean authenticate(UserAuthenticateDTO userAuthenticateDTO) {
        User user = userService.findUserByEmail(userAuthenticateDTO.getEmail());
        if (user == null) {
            return false;
        }
        return userService.authenticate(user, userAuthenticateDTO.getPassword());
    }

    public boolean isAdmin(UserDTO userDTO) {
        User user = userService.getUserById(userDTO.getId());
        return userService.isAdmin(user);
    }

    public boolean usernameExists(UserDTO userDTO) {
        return userService.findUserByUsername(userDTO.getUsername()) != null;
    }

    public boolean emailExists(UserDTO userDTO) {
        return userService.findUserByEmail(userDTO.getEmail()) != null;
    }

    public void changeUserImage(UserChangeImageDTO userChangeImageDTO) {
        User user = userService.getUserById(userChangeImageDTO.getUserId());
        user.setImage(userChangeImageDTO.getImage());
        user.setImageMimeType(userChangeImageDTO.getImageMimeType());
    }
}
