package cz.muni.fi.pa165.dao;

import java.util.List;

/**
 * Base interface for dao operations
 * @param <T> - Entity type
 *
 * @author Filip Sollar
 */
public interface BaseDao<T> {

    /**
     * Creates entity
     *
     * @param entity - entity to be created
     */
    void create(T entity);

    /**
     * Retrieves entity with given id
     * @param id - id of wanted entity
     * @return entity with corresponding id
     */
    T retrieve(Long id);

    /**
     * Updates the corresponding entity
     *
     * @param entity - entity to be updated
     */
    void update(T entity);

    /**
     * Deletes the entity
     *
     * @param entity - entity to be deleted
     */
    void delete(T entity);

    /**
     * Retrieves all entities
     *
     * @return all entities of given type
     */
    List<T> retrieveAll();

}
