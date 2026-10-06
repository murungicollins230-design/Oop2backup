package security;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DatabaseConnection {
    private static final String URL ="jdbc:mysql://localhost:3306/private_security_company";
    private static final String USERNAME= "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Connection successfull!");
            return connection;
            }catch(SQLException e){
                    System.out.println("Connection Failed!");
                    e.printStackTrace();
                    return null;
        }
    }

public static void main(String[] args){
    getConnection();
}


}