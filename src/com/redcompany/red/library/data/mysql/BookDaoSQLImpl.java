package com.redcompany.red.library.data.mysql;

import com.redcompany.red.library.entity.Book;
import com.redcompany.red.library.entity.Catalog;
import com.redcompany.red.library.entity.Library;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoSQLImpl implements DBCommand {

    private Library library;

    // CHANGE PARAMS!
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/red_db" +
                    "?verifyServerCertificate=false" +
                    "&useSSL=false" +
                    "&requireSSL=false" +
                    "&useLegacyDatetimeCode=false" +
                    "&amp" +
                    "&serverTimezone=UTC";
    ;
    private static final String DB_USER = "red";
    private static final String DB_PASS = "root";


    public BookDaoSQLImpl() {
        initBD();
    }

    @Override
    public Library getBookList() {

        List<Book> bookList = new ArrayList<Book>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM book");
            while (rs.next() == true) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Book book = new Book(id, title);
                bookList.add(book);
                System.out.println("id: " + id + ", " + "title" + title);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return library;
    }

    @Override
    public void initBD() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement stmt = connection.createStatement();
         //   ResultSet rs = st.executeQuery("SELECT * FROM library_db");
            if (testDB() == false) {
                if (fillDBDefaultValues(stmt) == true) {
                    System.out.println("Database was successfully initialized");
                }else {
                    System.out.println("Exception! Database (MYSQL) was not initialized!");
                    System.out.println("Working with it may lead to an error!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // fill standart values
    private boolean fillDBDefaultValues(Statement stmt ) {

        String sql;
        try {
            sql="CREATE DATABASE library_db; ";
            stmt.execute(sql);
            sql="USE library_db;";
            stmt.execute(sql);
         //   sql="CREATE TABLE my_library (id INTEGER AUTO_INCREMENT, authorcatalog VARCHAR(40), PRIMARY KEY (id));";
            stmt.execute("CREATE TABLE mylibrary(id INT PRIMARY KEY AUTO_INCREMENT,catalog_authors varchar(40) NOT NULL);");
            System.out.println();

//            stmt.execute(sql);
//            sql="INSERT INTO namesRanking (name, rating) VALUES ('Nikolaj',12344);";
//            stmt.execute(sql);
//            sql="INSERT INTO namesRanking (name, rating) VALUES ('Dmitrij', 12234);";
//            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error FILL DB !!!!");
            e.printStackTrace();
        }

        return false;
    }

    // поиск БД по названию
    private boolean testDB() {
        String dbNameFind = "library_db";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement st = connection.createStatement();
            ResultSet resultSet = connection.getMetaData().getCatalogs();
            while (resultSet.next()) {
                // Get the database name, which is at position 1
                String databaseName = resultSet.getString(1);
                if (databaseName.equals(dbNameFind)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Test
    public void testInitBD() {
        getBookList();
    }


}
