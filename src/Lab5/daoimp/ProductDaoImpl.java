package Lab5.daoimp;

import Lab5.ConnectionConfiguration;
import Lab5.dao.Dao;
import Lab5.entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements Dao<Product> {

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
            System.out.println("INSERT INTO user (name,company,price,available)" +
                    "VALUES (?, ?,?,?)");
        } catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            if(preparedStatement!=null)
                preparedStatement.close();
            if(connection!=null){
                connection.close();
            }
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
            if(resultSet!=null)
            {
                try {
                    resultSet.close();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }

            if(preparedStatement!=null)
            {
                try {
                    preparedStatement.close();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }

            }
            if(connection!=null) {
                try {
                    connection.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


        }
        return product;
    }

    @Override
    public List<Product> selectAll() {
        List<Product> products = new ArrayList<Product>();
        Connection connection = null;
        Statement statement = null;
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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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

            System.out.println("DELETE FROM product WHERE id = ?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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

            System.out.println("UPDATE product SET " +
                    "login = ?, password = ? WHERE id = ?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
