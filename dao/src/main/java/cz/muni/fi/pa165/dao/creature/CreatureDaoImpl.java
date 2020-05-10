package cz.muni.fi.pa165.dao.creature;

import cz.muni.fi.pa165.entity.Area;
import cz.muni.fi.pa165.entity.Creature;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Filip Sollar
 */
@Repository
public class CreatureDaoImpl implements CreatureDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Creature entity) { entityManager.persist(entity); }

    public Creature retrieve(Long id) {
        return entityManager.find(Creature.class, id);
    }

    public void update(Creature entity) {
        if (entity.getName() == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        entityManager.merge(entity);
    }

    public void delete(Creature entity) {
        entityManager.remove(entity);
    }

    public List<Creature> retrieveAll() {
        return entityManager.createQuery("select c from Creature c", Creature.class)
                .getResultList();
    }

    @Override
    public List<Creature> searchByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        return entityManager.createQuery("select c from Creature c where c.name=:name", Creature.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public void addArea(Long creatureId, Long areaId) {
        Area area = entityManager.find(Area.class, areaId);
        Creature creature = retrieve(creatureId);
        creature.getAreas().add(area);
        update(creature);
    }
}
