package cz.muni.fi.pa165.dao.user;

import cz.muni.fi.pa165.dao.BaseDao;
import cz.muni.fi.pa165.entity.User;

import java.util.List;

/**
 * Dao for operations on {@link User} entity
 *
 * @author Filip Sollar
 */
public interface UserDao extends BaseDao<User> {

    User findByEmail(String email);
    User findByUsername(String username);
    List<User> getAdmins();


}
