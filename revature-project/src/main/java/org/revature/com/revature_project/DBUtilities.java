package org.revature.com.revature_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtilities {

    Connection connection = null;
    Statement statement = null; 
    ResultSet resultSet = null; 

    public DBUtilities() throws SQLException {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://mybankdb.cgzlzv0lyi3b.us-east-2.rds.amazonaws.com:5432/mybankdb", "mybankdb", "mybankdb");

        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }

	public void DisconnectFromDB() {

        try {
            resultSet.close();
            statement.close();
            connection.close();
        }                                              
        catch (Exception ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }   
    }

    public ResultSet ReadRecords(String sql_stmt) {
        try {

            statement = connection.createStatement();
                                    
            resultSet = statement.executeQuery(sql_stmt);

            return resultSet;

        } 
        catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }                                                    

        return resultSet;
    }

    public void ExecuteSQLStatement(String sql_stmt) {
        try {
            statement = connection.createStatement();
                                    
            statement.executeUpdate(sql_stmt);
        } 
        catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }
}
