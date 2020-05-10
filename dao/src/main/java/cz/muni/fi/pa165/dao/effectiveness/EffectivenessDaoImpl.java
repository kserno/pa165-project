package cz.muni.fi.pa165.dao.effectiveness;

import cz.muni.fi.pa165.entity.Effectiveness;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Concrete implementation of {@link EffectivenessDao} using {@link PersistenceContext}
 *
 * @author Filip Sollar
 */
@Repository
public class EffectivenessDaoImpl implements EffectivenessDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Effectiveness entity) {
        entityManager.persist(entity);
    }

    public Effectiveness retrieve(Long id) {
        return entityManager.find(Effectiveness.class, id);
    }

    public void update(Effectiveness entity) {
        entityManager.merge(entity);
    }

    public void delete(Effectiveness entity) {
        entityManager.remove(entity);
    }

    public List<Effectiveness> retrieveAll() {
        return entityManager.createQuery("select we from Effectiveness we", Effectiveness.class)
                .getResultList();
    }
}
