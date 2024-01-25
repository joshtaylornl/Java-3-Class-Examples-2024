package ca.nl.cna.Java3.JDBC;

/**
 * This module is about playing around with JDBC using MariaDB.
 */
public class FunWithCallableStatements {

    public static void main(String[] args) {
        System.out.println("Fun with Callable Statements");
        FunWithSelectQueries.selectAllEmployees();

        /**
         * TODO: Josh totally knows how to do this. SO you do it!
         *
         * the following MySQL command will create a stored procedure that takes an employee ID and returns a name
         * CREATE PROCEDURE `getEmployeeName`(IN `employeeID` INT, OUT `employeeName` VARCHAR(255))
         * BEGIN
         * SELECT CONCAT(first, ' ', last) INTO employeeName FROM Employees WHERE id = employeeID;
         * END
         */

    }

}
