/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.bll;

import bookratingsystem.be.Book;
import bookratingsystem.dal.BookDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rasmus
 */
public class BookManager {

    private final BookDAO mBookDAO;

    public BookManager() {
        mBookDAO = BookDAO.getInstance();
    }

    public Book addBook(Book book) {
        try {
            return mBookDAO.add(book);
        } catch (SQLException ex) {
            System.out.println("Couldn't add book to database!");
            Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Creates a new book with the given paramters.
     *
     * @param bookData
     * @return
     */
    public Book createBook(String... bookData) {
        return new Book(bookData[0], bookData[1], bookData[2], bookData[3]);
    }

    /**
     * Gets all the books from the database.
     *
     * @return
     */
    public List<Book> getBooks() {
        return mBookDAO.getBooks();
    }

}
