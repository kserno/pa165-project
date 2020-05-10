package cz.muni.fi.pa165.dao.area;

import cz.muni.fi.pa165.dao.BaseDao;
import cz.muni.fi.pa165.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AreaDao extends BaseDao<Area> {

    List<Area> searchByName(String name);

}
