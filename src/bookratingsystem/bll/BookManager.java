/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.bll;

import bookratingsystem.be.Book;
import bookratingsystem.dal.FacadeDAL;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class BookManager {

    private final FacadeDAL mFacadeDAL;

    public BookManager() {
        mFacadeDAL = new FacadeDAL();
    }

    public Book addBook(Book book) {
        return mFacadeDAL.addBook(book);
    }

    /**
     * Creates a new book with the given paramters.
     *
     * @param bookData
     * @return
     */
    public Book createBook(String... bookData) {
        String[] AuthorAndTitle = bookData[1].split(",");
        return new Book(bookData[0], AuthorAndTitle[1], AuthorAndTitle[0]);
    }

    /**
     * Gets all the books from the database.
     *
     * @return
     */
    public List<Book> getBooks() {
        return mFacadeDAL.getBooks();
    }

}
