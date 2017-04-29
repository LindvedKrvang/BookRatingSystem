/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.gui.controller;

import bookratingsystem.be.Book;
import bookratingsystem.be.User;
import bookratingsystem.gui.model.BookModel;
import bookratingsystem.gui.model.UserRatingsModel;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rasmus
 */
public class AdminViewController implements Initializable {

    @FXML
    private TextField txtISBN;
    @FXML
    private TextField txtAuthorAndTitle;
    @FXML
    private TextField txtUserAndRating;

    private static final String[] BOOK_ISBN = new String[]{"01", "02", "03", "04", "05", "06", "07", "08",
        "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
        "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
        "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55"};

    private final BookModel mBookModel;
    private final UserRatingsModel mUserRatingsModel;

    public AdminViewController() {
        mBookModel = BookModel.getInstance();
        mUserRatingsModel = UserRatingsModel.getInstance();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleAddBookButton() {
        if (isDataValid()) {
            mBookModel.addBookToDB(txtISBN.getText(), txtAuthorAndTitle.getText());
            clearTxtFields();
        } else {
            System.out.println("Not valid data!");
        }
    }

    @FXML
    private void handleGetBooksButton() {
        List<Book> listOfBooks = mBookModel.getBooks();

        for (Book book : listOfBooks) {
            System.out.println("ISBN: " + book.getISBNNumber()
                    + "\nTitle: " + book.getTitle()
                    + "\nAuthor: " + book.getAuthor()
                    + "\n");
        }
    }

    private boolean isDataValid() {
        return (!txtISBN.getText().isEmpty() && !txtAuthorAndTitle.getText().isEmpty());
    }

    private void clearTxtFields() {
        txtISBN.clear();
        txtAuthorAndTitle.clear();
    }

    @FXML
    private void handleAddUserButton() {
        String[] userInput = txtUserAndRating.getText().split(" ");
        int[] ratings = new int[55];
        for (int i = 0; i < userInput.length; i++) {
            if (i < 55) {
                ratings[i] = Integer.parseInt(userInput[i + 1]);
            }
        }
        mUserRatingsModel.addUserAndRatingToDatabase(new User(userInput[0]), BOOK_ISBN, ratings);
        txtUserAndRating.clear();
    }

    @FXML
    private void handleGetRatingsButton() {
    }

}
