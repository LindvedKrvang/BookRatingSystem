/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.gui.model;

import bookratingsystem.be.Book;
import bookratingsystem.bll.BookManager;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class BookModel {

    public static BookModel mInstance;

    private final BookManager mBookManager;

    public static BookModel getInstance() {
        if (mInstance == null) {
            mInstance = new BookModel();
        }
        return mInstance;
    }

    private BookModel() {
        mBookManager = new BookManager();
    }

    public void addBookToDB(String... bookData) {
        mBookManager.addBook(mBookManager.createBook(bookData));
    }

    /**
     * Gets all the books from the database.
     *
     * @return
     */
    public List<Book> getBooks() {
        return mBookManager.getBooks();
    }
}
