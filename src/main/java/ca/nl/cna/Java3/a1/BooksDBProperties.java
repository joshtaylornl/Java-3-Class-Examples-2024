package ca.nl.cna.Java3.a1;

/**
 * Store all the MariaDB connection properties here.
 */
public class BooksDBProperties {

    static final String DB_URL = "jdbc:mariadb://localhost:3307";

    //?user=root&password=RootPwJoSh2024
    static final String USER = "root";
    static final String PASS = "RootPwJoSh2024";

    //Specific test database URL
    static final String JAVA_BOOKS_DB_URL = "jdbc:mariadb://localhost:3307/books?user=root&password=RootPwJoSh2024";

    static final String QUERY_ALL_AUTHORS = "SELECT * FROM authors;";
    static final String QUERY_ALL_TITLES = "SELECT * FROM titles;";

}
