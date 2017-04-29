/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.dal;

import bookratingsystem.be.Book;
import bookratingsystem.be.User;
import bookratingsystem.dal.bookDAOFolder.BookController;
import bookratingsystem.dal.ratingsDAOFolder.RatingsController;
import bookratingsystem.dal.userDAOFolder.UserController;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class FacadeDAL {

    private static FacadeDAL instance;

    private final IDAOController mBookController;
    private final IDAOController mUserController;
    private final RatingsController mRatingsController;

    public static FacadeDAL getInstance() {
        if (instance == null) {
            instance = new FacadeDAL();
        }
        return instance;
    }

    private FacadeDAL() {
        mBookController = new BookController();
        mUserController = new UserController();
        mRatingsController = new RatingsController();
    }

    /**
     * Adds a book to the database and returns it.
     *
     * @param book
     * @return
     */
    public Book addBook(Book book) {
        return (Book) mBookController.add(book);
    }

    /**
     * Get a List of all books from the database.
     *
     * @return
     */
    public List<Book> getBooks() {
        return mBookController.get();
    }

    /**
     * Adds a User to the database and returns it.
     *
     * @param user
     * @return
     */
    public User addUser(User user) {
        return (User) mUserController.add(user);
    }

    /**
     * Adds the parsed users ratings to the parsed books.
     *
     * @param userID
     * @param bookISBN
     * @param ratings
     */
    public void addRatingsToUser(int userID, String[] bookISBN, int[] ratings) {
        mRatingsController.addRating(userID, bookISBN, ratings);
    }

}
