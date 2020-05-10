package cz.muni.fi.pa165.service;

import cz.muni.fi.pa165.dao.creature.CreatureDao;
import cz.muni.fi.pa165.entity.Area;
import cz.muni.fi.pa165.entity.Creature;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Concrete implementation of {@link CreatureService}
 *
 * @author Filip Sollar
 */
@Service
public class CreatureServiceImpl implements CreatureService{

    @Inject
    private CreatureDao creatureDao;

    @Override
    public Creature getCreatureById(Long id) {
        return creatureDao.retrieve(id);
    }

    @Override
    public List<Creature> getAllCreatures() {
        return creatureDao.retrieveAll();
    }

    @Override
    public void createCreature(Creature creature) {
        creatureDao.create(creature);
    }

    @Override
    public void deleteCreature(Creature creature) {
        creatureDao.delete(creature);
    }

    @Override
    public void updateCreature(Creature creature) {
        creatureDao.update(creature);
    }

    @Override
    public void addCreatureToArea(Creature creature, Area area) {
        creature.getAreas().add(area);
    }

    @Override
    public void removeCreatureFromArea(Creature creature, Area area) {
        creature.getAreas().remove(area);
    }
}
