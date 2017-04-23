/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal;

import bookratingsystem.be.Book;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class FacadeDAL {

    private final IDAOController bookController;

    public FacadeDAL() {
        bookController = new BookController();
    }

    public Book addBook(Book book) {
        return (Book) bookController.add(book);
    }

    public List<Book> getBooks() {
        return bookController.get();
    }

}
