package ca.nl.cna.Java3.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Example to test the MariaDB Connection. And create a Database. Taken from JDBC Unit notes example "JDBCExample.java"
 */
public class FunWithDatabaseConnections {

    //Database parameters - "jdbc:mariadb" lets JDBC know to look for the Maria DB driver

    public static void main(String[] args) {
        // Open a connection
        try(Connection connection = DriverManager.getConnection(DBProperties.DB_URL, DBProperties.USER, DBProperties.PASS);
            Statement statement = connection.createStatement();
        ) {
            //If this Database already exists it will crash. You can "drop" it in the database view or use a drop query.
            String sql = "CREATE DATABASE STUDENTS";
            statement.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
