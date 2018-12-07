package com.redcompany.red.library.data.mysql;

import com.redcompany.red.library.entity.Book;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoSQLImpl implements DBCommand {

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

    }

    @Override
    public List<Book> getBookList() {

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

        return null;
    }

    @Override
    public void initBD() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement st = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testInitBD() {
        getBookList();
    }


}
