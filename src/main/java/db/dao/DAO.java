package db.dao;

import java.util.List;

public interface DAO <T, R>{
    R save(T dto);
    R getByID(Long id);
    List<R> getList();
    void deleteById(Long id);
}
