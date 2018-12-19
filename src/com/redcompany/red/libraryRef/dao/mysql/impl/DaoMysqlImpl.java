package com.redcompany.red.libraryRef.dao.mysql.impl;

import com.redcompany.red.libraryRef.dao.mysql.DBCommand;
import com.redcompany.red.libraryRef.entity.Author;
import com.redcompany.red.libraryRef.entity.Book;
import com.redcompany.red.libraryRef.entity.Library;
import com.redcompany.red.libraryRef.service.serviceCommand.Director;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public enum DaoMysqlImpl implements DBCommand {

    INSTANCE;


    private static final String SQL_INSERT_AUTHOR = "INSERT INTO author (author_name) VALUES (?)";

    private String standart_db = "jdbc:mysql://localhost:3306/mysql" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";
    // CHANGE PARAMS!
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/librarywebnew" +
                    "?verifyServerCertificate=false" +
                    "&useSSL=false" +
                    "&requireSSL=false" +
                    "&useLegacyDatetimeCode=false" +
                    "&amp" +
                    "&serverTimezone=UTC";
    ;
    private static final String DB_USER = "red";
    private static final String DB_PASS = "root";

    private DaoMysqlImpl() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            initBD();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Library getLibrary() {
        Library libraryDB = new Library();
        List<Author> authorList = libraryDB.createNewAuthorList();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement st = connection.createStatement();
            collectAuthorsFromRS(st, authorList);
            collectBooksFromRS(st, authorList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libraryDB;
    }

    @Override
    public List<Author> getAuthorList() {
        List<Author> authorList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement st = connection.createStatement();
            collectAuthorsFromRS(st, authorList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authorList;
    }

    @Override
    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement st = connection.createStatement();
            getBookListFromDB(st, bookList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public void addNewAuthorInDb(String author_name) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement stmt = connection.createStatement();
            String sql;
            sql = "USE librarywebnew;";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`mylibrary` (`catalog_authors`) VALUES ('" + author_name + "');";
            stmt.execute(sql);
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Error FILL DB !!!!");
            e.printStackTrace();
        }

    }

    @Override
    public void addNewBookInDb(String book_name) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement stmt = connection.createStatement();
            String sql;
            sql = "USE librarywebnew;";
            stmt.execute(sql);
            //4 = Unknown author
            sql = "INSERT INTO `librarywebnew`.`catalog_books` (`book_title`,`auth_id`) VALUES ('" + book_name + "'," + 4 + ");";
            stmt.execute(sql);
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Error FILL DB !!!!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBookInDb(String id_book) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement stmt = connection.createStatement();
            int num = Integer.parseInt(id_book);
            System.out.println(num);
            String sql;
            sql = "USE librarywebnew;";
            stmt.execute(sql);
            sql = "DELETE FROM `librarywebnew`.`catalog_books` WHERE `id` = " + num + ";";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error FILL DB !!!!");
            e.printStackTrace();
        }
    }


    @Override
    public void editBookInDb(String id_book, String book_name) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql;
            Statement stmt = connection.createStatement();
            int num = Integer.parseInt(id_book);
            sql = "USE librarywebnew;";
            stmt.execute(sql);
            sql = "UPDATE `librarywebnew`.`catalog_books` t SET t.`book_title` = '" + book_name + "' WHERE t.`id` =" + num + ";";
            stmt.execute(sql);
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Error FILL DB !!!!");
            e.printStackTrace();
        }
    }

    @Override
    public Book findBookInDb(String book_name) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            Statement stmt = connection.createStatement();
            System.out.println(book_name);
            String sql = "USE librarywebnew;";
            stmt.execute(sql);
            ResultSet rs = stmt.executeQuery("SELECT id,book_title FROM librarywebnew.catalog_books WHERE book_title  LIKE '%"+book_name+"%';");
            if (rs.next() == true) {
                int id_book = rs.getInt("id");
                String title = rs.getString("book_title");
                Book book = new Book(id_book, title);
                return book;
            }
        } catch (SQLException e) {
            System.err.println("Error FILL DB !!!!");
            e.printStackTrace();
        }
        return null;
    }


    private void collectAuthorsFromRS(Statement st, List<Author> authorList) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM mylibrary;");
        while (rs.next() == true) {
            Author author = new Author();
            String author_name = rs.getString("catalog_authors");
            author.setResponsiblePerson(author_name);
            author.setCreationData(new Date());
            authorList.add(author);
        }
        rs.close();
    }

    private void collectBooksFromRS(Statement st, List<Author> authorList) throws SQLException {
        for (int i = 0; i < authorList.size(); i++) {
            Author author = authorList.get(i);
            List<Book> bookList = new ArrayList<>();
            String find = String.valueOf(i + 1);
            ResultSet rs = st.executeQuery("SELECT id, book_title FROM catalog_books\n" +
                    "WHERE auth_id =" + find + ";");
            while (rs.next() == true) {
                int id_book = rs.getInt("id");
                String title = rs.getString("book_title");
                Book book = new Book(id_book, title);
                bookList.add(book);
            }
            author.setBooks(bookList);
        }
    }

    private void getBookListFromDB(Statement st, List<Book> bookList) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT id, book_title FROM catalog_books;");
        while (rs.next() == true) {
            int id_book = rs.getInt("id");
            String title = rs.getString("book_title");
            Book book = new Book(id_book, title);
            bookList.add(book);
        }
        rs.close();
    }

    private void initBD() {
        if (testDB() == false) {
            try (Connection connection = DriverManager.getConnection(standart_db, DB_USER, DB_PASS)) {
                Statement stmt = connection.createStatement();
                if (fillDBDefaultValues(stmt) == true) {
                    System.out.println("Database was successfully initialized");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Database was created earlier");
        }
    }

    // fill standart values
    private boolean fillDBDefaultValues(Statement stmt) {
        String sql;
        try {
            sql = "CREATE DATABASE librarywebnew; ";
            stmt.execute(sql);
            sql = "USE librarywebnew;";
            stmt.execute(sql);
            sql = "CREATE TABLE mylibrary(id INT PRIMARY KEY AUTO_INCREMENT,catalog_authors varchar(40) NOT NULL);";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`mylibrary` (`catalog_authors`) VALUES ('Ivan Ivanov');";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`mylibrary` (`catalog_authors`) VALUES ('Petya Petrov');";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`mylibrary` (`catalog_authors`) VALUES ('Vasya Vasiliev');";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`mylibrary` (`catalog_authors`) VALUES ('Unknown author');";
            stmt.execute(sql);
            sql = "CREATE TABLE catalog_books(id INT PRIMARY KEY AUTO_INCREMENT,book_title varchar(40) NOT NULL, auth_id INT , FOREIGN KEY  (auth_id) REFERENCES mylibrary(id));";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A1_BOOK_1',1);";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A1_BOOK_2',1);";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A1_BOOK_3',1);";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A2_BOOK_1',2);";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A2_BOOK_2',2);";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A2_BOOK_3',2);";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A3_BOOK_1',3);";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A3_BOOK_2',3);";
            stmt.execute(sql);
            sql = "INSERT INTO `librarywebnew`.`catalog_books` (`book_title`, `auth_id`) VALUES ('A3_BOOK_3',3);";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error FILL DB !!!!");
            e.printStackTrace();
        }
        return true;
    }

    // поиск БД по названию
    private boolean testDB() {
        String dbNameFind = "librarywebnew";
        try (Connection connection = DriverManager.getConnection(standart_db, DB_USER, DB_PASS)) {
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
        initBD();
    }



}
