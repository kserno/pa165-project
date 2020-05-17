package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.user.UserDao;
import cz.muni.fi.pa165.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Concrete implementation of {@link UserService}
 *
 * @author Filip Sollar
 */
@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao userDao;

    @Autowired
    private HashingService hashingService;

    public void registerUser(User user, String unencryptedPassword) {
        user.setPasswordHash(hashingService.createHash(unencryptedPassword));
        userDao.create(user);
    }

    public List<User> getAllUsers() {
        return userDao.retrieveAll();
    }

    public List<User> getAdmins() {
        return userDao.getAdmins();
    }

    public boolean authenticate(User user, String password) {
        return hashingService.validatePassword(password, user.getPasswordHash());
    }

    public boolean isAdmin(User user) {
        return userDao.retrieve(user.getId()).isAdmin();
    }



    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User getUserById(Long userId) {
        return userDao.retrieve(userId);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
