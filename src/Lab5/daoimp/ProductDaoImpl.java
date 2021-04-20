package Lab5.daoimp;

import Lab5.ClosingThreads.ClosingThreads;
import Lab5.ConnectionConfiguration;
import Lab5.dao.Dao;
import Lab5.entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements Dao<Product> {
    ClosingThreads closingThreads=new ClosingThreads();
    @Override
    public void insert(Product product) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO product (name,company,price,available)" +
                    "VALUES (?, ?,?,?)");
            preparedStatement.setString(1,product.getNameOfTheProduct());
            preparedStatement.setString(2,product.getCompanyNameOfAProduct());
            preparedStatement.setInt(3,product.getPriceOfAProduct());
            preparedStatement.setBoolean(4,product.isAvailable());
            preparedStatement.executeUpdate();
            System.out.println("INSERTED SUCCESSFULLY");
        } catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingPreparedStatement(preparedStatement);
        }
    }

    @Override
    public Product selectBYId(int id) throws SQLException {
        Product product=new Product();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            connection=ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("SELECT * FROM product WHERE id=?");
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                product.setId(resultSet.getInt("id"));
                product.setNameOfTheProduct(resultSet.getString("name"));
                product.setCompanyNameOfAProduct(resultSet.getString("company"));
                product.setPriceOfAProduct(resultSet.getInt("price"));
                product.setAvailable(resultSet.getBoolean("available"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingPreparedStatement(preparedStatement);
            closingThreads.ClosingResultSet(resultSet);
        }
        return product;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> products = new ArrayList<Product>();
        Connection connection = null;
        Statement statement= null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM product");
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setNameOfTheProduct(resultSet.getString("name"));
                product.setCompanyNameOfAProduct(resultSet.getString("company"));
                product.setPriceOfAProduct(resultSet.getInt("price"));
                product.setAvailable(resultSet.getBoolean("available"));
                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingStatement(statement);
            closingThreads.ClosingResultSet(resultSet);
        }
        return products;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("DELETED SUCCESSFULLY!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingPreparedStatement(preparedStatement);

        }
    }

    @Override
    public void update(Product product, int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE product SET " +
                    "name = ?, company = ?, price = ? , available = ? WHERE id = ?");

            preparedStatement.setString(1, product.getNameOfTheProduct());
            preparedStatement.setString(2, product.getCompanyNameOfAProduct());
            preparedStatement.setInt(3, product.getPriceOfAProduct());
            preparedStatement.setBoolean(4, product.isAvailable());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

            System.out.println("UPDATED SUCCESSFULLY!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingPreparedStatement(preparedStatement);
        }
    }

}
