package cz.muni.fi.pa165.dao.area;

import cz.muni.fi.pa165.dao.effectiveness.EffectivenessDao;
import cz.muni.fi.pa165.entity.Area;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Concrete implementation of {@link AreaDao} using {@link PersistenceContext}
 *
 * @author Filip Sollar
 */
@Repository
public class AreaDaoImpl implements AreaDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Area entity) {
        entityManager.persist(entity);
    }

    public Area retrieve(Long id) {
        return entityManager.find(Area.class, id);
    }

    public void update(Area entity) {
        entityManager.merge(entity);
    }

    public void delete(Area entity) {
        entityManager.remove(entity);
    }

    public List<Area> retrieveAll() {
        return entityManager.createQuery("select a from Area a", Area.class)
                .getResultList();
    }

    @Override
    public List<Area> searchByName(String name) {
        return entityManager.createQuery("select a from Area a where a.name = :name", Area.class)
                .setParameter("name", name)
                .getResultList();
    }
}
