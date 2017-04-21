/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal;

import bookratingsystem.be.Book;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rasmus
 */
public class BookDAO {

    private static BookDAO mInstance;

    private DBConnectionManager cm;

    public static BookDAO getInstance() {
        if (mInstance == null) {
            mInstance = new BookDAO();
        }
        return mInstance;
    }

    private BookDAO() {
        cm = null;
        try {
            cm = DBConnectionManager.getInstance();
        } catch (IOException ex) {
            System.out.println("Couldnt connect to DB!");
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Book add(Book book) throws SQLException {
        String sql = "INSERT INTO Books (ISBN, Title, Author) VALUES (?,?,?)";
        try (Connection con = cm.getConnection()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getISBNNumber());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());

            ps.executeUpdate();
            return new Book(book);
        }

    }

    public List<Book> getBooks() {
        List<Book> listOfBooks = new ArrayList<>();
        String sql = "SELECT * FROM Books";
        try (Connection con = cm.getConnection()) {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listOfBooks.add(getOneBook(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
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
