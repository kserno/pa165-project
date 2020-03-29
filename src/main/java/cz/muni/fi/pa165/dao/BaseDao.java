package cz.muni.fi.pa165.dao;

import java.util.List;

public interface BaseDao<T> {

    void create(T entity);
    T retrieve(Long id);
    void update(T entity);
    void delete(T entity);

    List<T> retrieveAll();

}
