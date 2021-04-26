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
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet=null;
        try{
            connection = ConnectionConfiguration.getConnection();
            preparedStatement1=connection.prepareStatement("SELECT login, password FROM user where login=? OR password=?");
            preparedStatement1.setString(1, user.getLogin());
            preparedStatement1.setString(2, user.getPassword());
            resultSet=preparedStatement1.executeQuery();
            if(resultSet.next()){
                System.out.println("Username/password was taken!!!");
            }
            else{
            connection=ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("INSERT INTO user (login,password)" + "VALUES (?, ?)");
            preparedStatement.setString(1,user.getLogin());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.executeUpdate();
            System.out.println("INSERTED SUCCESSFULLY!");
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
    public void delete(String oldLogin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet=null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement1=connection.prepareStatement
                    ("SELECT login, password FROM user WHERE login = ? ");
            preparedStatement1.setString(1,oldLogin);
            resultSet=preparedStatement1.executeQuery();
            if(resultSet.next()){
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM user WHERE login = ?");
            preparedStatement.setString(1, oldLogin);
            preparedStatement.executeUpdate();
            System.out.println("DELETED SUCCESSFULLY!");}
            else{
                System.out.println("There is no such user to delete!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closingThreads.ClosingConnection(connection);
            closingThreads.ClosingPreparedStatement(preparedStatement);

        }
    }

    @Override
    public void update(User user, String oldLogin) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1=null;
        ResultSet resultSet=null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement1=connection.prepareStatement
                    ("SELECT login, password FROM user WHERE login = ? ");
            preparedStatement1.setString(1,oldLogin);
            resultSet=preparedStatement1.executeQuery();
            if(resultSet.next()){
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE user SET " +
                    "login = ?, password = ? WHERE login = ?");

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, oldLogin);
            preparedStatement.executeUpdate();

            System.out.println("UPDATED SUCCESSFULLY!");}
            else{
                System.out.println("There is no such user to update!");
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
