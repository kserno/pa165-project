package cz.muni.fi.pa165.dao.user;

import cz.muni.fi.pa165.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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
        User oldEntity = retrieve(entity.getId());
        em.getTransaction().begin();

        oldEntity.setAdmin(entity.isAdmin());
        oldEntity.setEmail(entity.getEmail());
        oldEntity.setName(entity.getName());
        oldEntity.setUsername(entity.getUsername());
        oldEntity.setPasswordHash(entity.getPasswordHash());

        em.getTransaction().commit();
    }

    public void delete(User entity) {
        em.remove(entity);
    }

    public List<User> retrieveAll() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM user u",
                User.class);
        return query.getResultList();
    }

}
