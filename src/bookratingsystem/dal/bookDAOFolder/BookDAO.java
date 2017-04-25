/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal.bookDAOFolder;

import bookratingsystem.be.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class BookDAO {

    private static BookDAO mInstance;

    public static BookDAO getInstance() {
        if (mInstance == null) {
            mInstance = new BookDAO();
        }
        return mInstance;
    }

    /**
     * Adds a single Book to the database. The Book that is added is the one
     * that is parsed.
     *
     * @param con
     * @param book
     * @return
     * @throws SQLException
     */
    public Book add(Connection con, Book book) throws SQLException {
        String sql = "INSERT INTO Books (ISBN, Title, Author) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, book.getISBNNumber());
        ps.setString(2, book.getTitle());
        ps.setString(3, book.getAuthor());

        ps.executeUpdate();
        return new Book(book);
    }

    /**
     * Returns a List of all the Books in the database.
     *
     * @param con
     * @return
     * @throws SQLException
     */
    public List<Book> getBooks(Connection con) throws SQLException {
        List<Book> listOfBooks = new ArrayList<>();
        String sql = "SELECT * FROM Books";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            listOfBooks.add(getOneBook(rs));
        }
        return listOfBooks;
    }

    /**
     * Creates a single book from the given ResulSet.
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    private Book getOneBook(ResultSet rs) throws SQLException {
        String ISBN = rs.getString("ISBN");
        String title = rs.getString("Title");
        String author = rs.getString("Author");

        return new Book(ISBN, title, author);
    }
}
