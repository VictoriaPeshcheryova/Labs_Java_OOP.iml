package Lab5.dao;

import Lab5.entities.Product;
import Lab5.entities.User;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    void createProductTable() throws SQLException;
    void insert(Product product) throws SQLException;
    Product selectBYId(int id) throws SQLException;
    List<Product> selectAll();
    void delete(int id);
    void update(Product product,int id);
}
