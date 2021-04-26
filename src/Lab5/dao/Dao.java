package Lab5.dao;
import java.sql.SQLException;
import java.util.List;


public interface Dao<T> {
    void insert(T object) throws SQLException;
    T selectBYId(int id) throws SQLException;
    List<T> selectAll();
    void delete(String oldParameter);
    void update(T object,String oldParameter);
}
