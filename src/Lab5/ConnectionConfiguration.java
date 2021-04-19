package Lab5;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {
    public static Connection getConnection(){
        Connection connection=null;
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/users","eunoiakaira", "erentraher2526STASlol2_2");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return connection;
    }
}
