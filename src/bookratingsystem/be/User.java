/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.be;

import java.util.HashMap;

/**
 *
 * @author Rasmus
 */
public class User {

    private String mName;
    private int mId;
    private HashMap<String, Integer> mBookRatings;

    public User(String name) {
        mName = name;
        mId = 0;
        mBookRatings = new HashMap<>();
    }

    public User(String name, int id) {
        mName = name;
        mId = id;
        mBookRatings = new HashMap<>();
    }

    public User(User user) {
        mName = user.getName();
        mId = user.getId();
        mBookRatings = new HashMap<>();
    }

    public String getName() {
        return mName;
    }

    public int getId() {
        return mId;
    }

    /**
     * Adds a rating for a book to the user.
     *
     * @param bookISBN
     * @param rating
     */
    public void addBookRating(String bookISBN, int rating) {
        mBookRatings.put(bookISBN, rating);
    }

    /**
     * Prints the ratings of the User.
     */
    public void printRatings() {
        for (String key : mBookRatings.keySet()) {
            System.out.println("Book nr. " + key + ": " + mBookRatings.get(key));
        }
    }
}
