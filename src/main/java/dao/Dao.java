package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao <T, ID> {
    Optional<T> findById(ID id) throws SQLException;
    List<T> findAll() throws SQLException;
    boolean save(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
}
