package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.entity.User;

import java.util.List;

/**
 * Service for handling interactions with {@link User} object
 *
 * @author Filip Sollar
 */
public interface UserService {

    /**
     * Registers user with given credentials
     *
     * @param user - User's data
     * @param unencryptedPassword - password in plaintext format, will be saved as hash
     */
    void registerUser(User user, String unencryptedPassword);

    /**
     * Gets all users of system
     *
     * @return list of system's users
     */
    List<User> getAllUsers();

    /**
     * Gets all admins of system
     *
     * @return admins of system
     */
    List<User> getAdmins();

    /**
     * Authenticates user
     *
     * @param user - User data
     * @param password plaintext password
     * @return true or false whether authentications finishes successfully or not
     */
    boolean authenticate(User user, String password);

    /**
     * returns whether user is admin or not
     *
     * @param user - User to be checked
     * @return true or false whether user is admin or not
     */
    boolean isAdmin(User user);

    /**
     * Returns user by email
     * @param email - email of user's
     * @return User with given email
     */
    User findUserByEmail(String email);

    /**
     * Get user by id
     * @param userId - id of user
     * @return User with given id
     */
    User getUserById(Long userId);


    /**
     * @param username - username for user
     * @return User with given username
     */
    User findUserByUsername(String username);
}
