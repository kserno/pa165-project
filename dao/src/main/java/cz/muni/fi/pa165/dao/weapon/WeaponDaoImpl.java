package cz.muni.fi.pa165.dao.weapon;

import cz.muni.fi.pa165.dao.effectiveness.EffectivenessDao;
import cz.muni.fi.pa165.entity.Weapon;
import cz.muni.fi.pa165.enums.AmmunitionType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Concrete implementation of {@link WeaponDao} using {@link PersistenceContext}
 *
 * @author Filip Sollar
 */
@Repository
public class WeaponDaoImpl implements WeaponDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Weapon entity) {
        entityManager.persist(entity);
    }

    public Weapon retrieve(Long id) {
        return entityManager.find(Weapon.class, id);
    }

    public void update(Weapon entity) {
        entityManager.merge(entity);
    }

    public void delete(Weapon entity) {
        entityManager.remove(entity);
    }

    public List<Weapon> retrieveAll() {
        return entityManager.createQuery("select w from Weapon w", Weapon.class)
                .getResultList();
    }

    @Override
    public List<Weapon> searchByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty or null");
        }
        return entityManager.createQuery("select w from Weapon w where w.name = :name", Weapon.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public List<Weapon> retrieveByAmmunitionType(AmmunitionType ammunitionType) {
        if (ammunitionType == null) {
            throw new IllegalArgumentException("ammunitionType cannot be null");
        }
        return entityManager.createQuery("select w from Weapon w where w.ammunitionType = :ammunitionType", Weapon.class)
                .setParameter("ammunitionType", ammunitionType)
                .getResultList();
    }
}
