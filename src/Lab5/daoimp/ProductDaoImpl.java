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
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet=null;
        try{
            connection = ConnectionConfiguration.getConnection();
            preparedStatement1=connection.prepareStatement
                    ("SELECT * FROM product where name=?");
            preparedStatement1.setString(1,product.getNameOfTheProduct());
            resultSet=preparedStatement1.executeQuery();
            if(resultSet.next()){
            System.out.println("We already have this product");
            }
            else{
                connection=ConnectionConfiguration.getConnection();
                preparedStatement=connection.prepareStatement("INSERT INTO product (name,company,price,available)" +
                        "VALUES (?, ?,?,?)");
                preparedStatement.setString(1,product.getNameOfTheProduct());
                preparedStatement.setString(2,product.getCompanyNameOfAProduct());
                preparedStatement.setInt(3,product.getPriceOfAProduct());
                preparedStatement.setBoolean(4,product.isAvailable());
                preparedStatement.executeUpdate();
                System.out.println("INSERTED SUCCESSFULLY");
            }

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
    public void delete(String oldName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet=null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement1=connection.prepareStatement
                    ("SELECT name, company, price, available FROM product WHERE name = ? ");
            preparedStatement1.setString(1,oldName);
            resultSet=preparedStatement1.executeQuery();
            if(resultSet.next()){
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM product WHERE name = ?");
            preparedStatement.setString(1, oldName);
            preparedStatement.executeUpdate();
            System.out.println("DELETED SUCCESSFULLY!");}
            else{
                System.out.println("There's no such product to delete!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingPreparedStatement(preparedStatement);

        }
    }

    @Override
    public void update(Product product, String oldName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet=null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement1=connection.prepareStatement
                    ("SELECT name, company, price, available FROM product WHERE name = ? ");
            preparedStatement1.setString(1,oldName);
            resultSet=preparedStatement1.executeQuery();
            if(resultSet.next()){
                preparedStatement = connection.prepareStatement("UPDATE product SET " +
                        "name = ?, company = ?, price = ? , available = ? WHERE name= ?");

                preparedStatement.setString(1, product.getNameOfTheProduct());
                preparedStatement.setString(2, product.getCompanyNameOfAProduct());
                preparedStatement.setInt(3, product.getPriceOfAProduct());
                preparedStatement.setBoolean(4, product.isAvailable());
                preparedStatement.setString(5, oldName);
                preparedStatement.executeUpdate();
                System.out.println("UPDATED SUCCESSFULLY!");
            }
            else{
                System.out.println("There's no such product to update!!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingPreparedStatement(preparedStatement);
            closingThreads.ClosingResultSet(resultSet);
        }
    }

}
