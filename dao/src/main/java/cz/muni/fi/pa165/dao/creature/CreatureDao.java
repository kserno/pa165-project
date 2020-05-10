package cz.muni.fi.pa165.dao.creature;

import cz.muni.fi.pa165.dao.BaseDao;
import cz.muni.fi.pa165.entity.Creature;

import java.util.List;

/**
 * Dao for operations on {@link Creature}
 *
 * @author Filip Sollar
 */
public interface CreatureDao extends BaseDao<Creature> {

    List<Creature> searchByName(String name);
    void addArea(Long creatureId, Long areaId);

}
