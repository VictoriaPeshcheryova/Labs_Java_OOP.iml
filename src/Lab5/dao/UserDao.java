package Lab5.dao;



import Lab5.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void createUserTable() throws SQLException;
    void insert(User user) throws SQLException;
    Lab5.entities.User selectBYId(int id) throws SQLException;
    List<Lab5.entities.User> selectAll();
    void delete(int id);
    void update(User user,int id);

}
