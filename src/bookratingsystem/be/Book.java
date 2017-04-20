/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.be;

/**
 *
 * @author Rasmus
 */
public class Book {

    private String mISBNNumber;
    private String mTitle;
    private String mYear;
    private String mAuthor;

    public Book(String ISBNNumber, String title, String year, String author) {
        mISBNNumber = ISBNNumber;
        mTitle = title;
        mYear = year;
        mAuthor = author;
    }

    public String getISBNNumber() {
        return mISBNNumber;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getYear() {
        return mYear;
    }

    public String getAuthor() {
        return mAuthor;
    }
}
