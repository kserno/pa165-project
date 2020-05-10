package cz.muni.fi.pa165.api.facade;

import cz.muni.fi.pa165.api.dto.user.*;

import java.util.List;

/**
 * Facade for User operations
 *
 * @author Filip Sollar
 */
public interface UserFacade {

    /**
     * Creates the user
     * @param userRegisterDTO - DTO representing the data of new user
     * @return id of created entity
     */
    Long registerUser(UserRegisterDTO userRegisterDTO);

    /**
     * Returns user specified by id in form of {@link UserDTO}
     * @param id - id of user
     * @return User in form of DTO
     */
    UserDTO findUserById(Long id);

    /**
     * Returns user specified by email in form of {@link UserDTO}
     * @param email - email of user
     * @return User in form of DTO
     */
    UserDTO findUserByEmail(String email);

    /**
     * Returns all users
     * @return list of users in form of {@link UserListDTO}
     */
    List<UserListDTO> getAllUsers();
    /**
     * Returns all admins of system
     * @return list of users in form of {@link UserListDTO}
     */
    List<UserListDTO> getAdmins();

    /**
     * Authenticates the user using given credentials
     * @param userAuthenticateDTO - DTO representing authenticating credentials
     * @return true or false based whether the authentication was successful or not
     */
    boolean authenticate(UserAuthenticateDTO userAuthenticateDTO);

    /**
     * Returns whether user is admin or not
     *
     * @param userDTO - DTO representing user
     * @return true or false based whether user is admin or not
     */
    boolean isAdmin(UserDTO userDTO);

    /**
     * Checks whether username already exists in database
     * @param userDTO - DTO representing user with username
     * @return true or false based on whether username is already present in db
     */
    boolean usernameExists(UserDTO userDTO);

    /**
     * Checks whether email already exists in database
     * @param userDTO - DTO representing user with email
     * @return true or false based on whether email is already present in db
     */
    boolean emailExists(UserDTO userDTO);

    /**
     * Changes the user's iamge
     * @param userChangeImageDTO - DTO representing data of changed image
     */
    void changeUserImage(UserChangeImageDTO userChangeImageDTO);

}
