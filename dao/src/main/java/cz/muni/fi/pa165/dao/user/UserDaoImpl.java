package cz.muni.fi.pa165.dao.user;

import cz.muni.fi.pa165.dao.effectiveness.EffectivenessDao;
import cz.muni.fi.pa165.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Concrete implementation of {@link UserDao} using {@link PersistenceContext}
 *
 * @author Filip Sollar
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public void create(User entity) {
        em.persist(entity);
    }

    public User retrieve(Long id) {
        return em.find(User.class, id);
    }

    public void update(User entity) {
        em.merge(entity);
    }

    public void delete(User entity) {
        em.remove(entity);
    }

    public List<User> retrieveAll() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u",
                User.class);
        return query.getResultList();
    }

    @Override
    public User findByEmail(String email) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.email=:email", User.class)
                .setParameter("email", email)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.username=:username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public List<User> getAdmins() {
        return em.createQuery("SELECT u FROM User u WHERE u.isAdmin=true", User.class)
                .getResultList();
    }
}
