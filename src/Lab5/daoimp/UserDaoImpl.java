package Lab5.daoimp;

import Lab5.ClosingThreads.ClosingThreads;
import Lab5.ConnectionConfiguration;
import Lab5.dao.Dao;
import Lab5.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Dao <User>{
    ClosingThreads closingThreads=new ClosingThreads();

    @Override
    public void insert(User user) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO user (login,password)" +
                    "VALUES (?, ?)");
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO users (login,password)" +
                    "VALUES(?,?)");
        } catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingPreparedStatement(preparedStatement);

        }
    }

    @Override
    public User selectBYId(int id) throws SQLException {

        User user=new User();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            connection=ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("SELECT * FROM user WHERE id=?");
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();

            while(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
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
        return user;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM user");

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingStatement(statement);
            closingThreads.ClosingResultSet(resultSet);

        }
        return users;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("DELETE FROM user WHERE id = ?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingPreparedStatement(preparedStatement);

        }
    }

    @Override
    public void update(User user, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE user SET " +
                    "login = ?, password = ? WHERE id = ?");

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();

            System.out.println("UPDATE user SET " +
                    "login = ?, password = ? WHERE id = ?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingPreparedStatement(preparedStatement);
        }
    }
}
