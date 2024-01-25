package ca.nl.cna.Java3.JDBC;

import java.sql.*;

/**
 * An example of using Prepared Statements. Taken from Unit 2 notes on D2L.
 *
 * This example uses the java_test database set up previously.
 *
 * To prepare the database use the following script:
 * create database java_test;
 * create table Employees ( Id int not null, age int not null, first varchar (255), last varchar (255) );
 * INSERT INTO Employees VALUES (100, 40, 'Albert', 'Norman');
 * INSERT INTO Employees VALUES (101, 42, 'Josh', 'Taylor');
 * INSERT INTO Employees VALUES (102, 41, 'Richard', 'Spencer');
 * INSERT INTO Employees VALUES (103, 58, 'Chris', 'Gash');
 */
public class FunWithPreparedStatements {

    private static String UPDATE_QUERY = "UPDATE Employees SET age=? WHERE id=?;";
    public static void main(String[] args) {
        System.out.println("Fun with Prepared Statements");

        try(    //Try with resources - automatically closes the connection
                Connection conn = DriverManager.getConnection(DBProperties.JAVA_TEST_DB_URL);
                PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_QUERY);
        ) {

            //101 is the ID of Josh Taylor, he is 42 years old. We are going to change his age to 44.
            preparedStatement.setInt(1, 34);
            preparedStatement.setInt(2, 101);
            preparedStatement.execute();

            //Just to be sure
            System.out.printf("The prepared statement is: %s", preparedStatement.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("\n Test to see if the change has been made: \n");

        FunWithSelectQueries.selectAllEmployees();

    }

}
