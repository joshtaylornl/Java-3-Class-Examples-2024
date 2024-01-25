package ca.nl.cna.Java3.JDBC;

import java.sql.*;

/**
 * An example showing a result set. To prepare the database use the following script:
 * create database java_test;
 * create table Employees ( Id int not null, age int not null, first varchar (255), last varchar (255) );
 * INSERT INTO Employees VALUES (100, 40, 'Albert', 'Norman');
 * INSERT INTO Employees VALUES (101, 42, 'Josh', 'Taylor');
 * INSERT INTO Employees VALUES (102, 41, 'Richard', 'Spencer');
 * INSERT INTO Employees VALUES (103, 58, 'Chris', 'Gash');
 */
public class FunWithSelectQueries {

    static final String QUERY = "SELECT id, first, last, age FROM Employees";

    public static void main(String[] args) {
        System.out.println("Fun with Select Queries");
        selectAllEmployees();
    }

    /**
     * Connect to the java_test database and select all employees. Print them to the console.
     */
    public static void selectAllEmployees(){
        try(    //Try with resources - automatically closes the connection
                Connection conn = DriverManager.getConnection(DBProperties.JAVA_TEST_DB_URL);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
        ) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.println(", Last: " + rs.getString("last"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
