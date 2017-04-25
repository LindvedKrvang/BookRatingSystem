/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal.bookDAOFolder;

import bookratingsystem.be.Book;
import bookratingsystem.dal.DBConnectionManager;
import bookratingsystem.dal.IDAOController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class BookController implements IDAOController<Book> {

    private DBConnectionManager cm;

    private final BookDAO bookDAO;

    public BookController() {
        try {
            cm = DBConnectionManager.getInstance();
        } catch (IOException ex) {
            System.out.println("Failed to connect to database!\n" + ex.getMessage());
        }
        bookDAO = BookDAO.getInstance();
    }

    @Override
    public Book add(Book t) {
        try {
            return bookDAO.add(cm.getConnection(), t);
        } catch (SQLException ex) {
            System.out.println("Couldn't add book to database!\n" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Book> get() {
        try {
            return bookDAO.getBooks(cm.getConnection());
        } catch (SQLException ex) {
            System.out.println("Couldn't get books from database\n" + ex.getMessage());
            return null;
        }
    }
}
