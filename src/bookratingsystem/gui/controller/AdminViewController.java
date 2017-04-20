/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.gui.controller;

import bookratingsystem.be.Book;
import bookratingsystem.gui.model.BookModel;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
    private TextField txtTitle;
    @FXML
    private TextField txtYear;
    @FXML
    private TextField txtAuthor;

    private BookModel mBookModel;

    public AdminViewController() {
        mBookModel = BookModel.getInstance();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleAddBookButton(ActionEvent event) {
        if (isDataValid()) {
            mBookModel.addBookToDB(txtISBN.getText(), txtTitle.getText(),
                    txtYear.getText(), txtAuthor.getText());
            clearTxtFields();
        } else {
            System.out.println("Not valid data!");
        }
    }

    @FXML
    private void handleGetBooksButton(ActionEvent event) {
        List<Book> listOfBooks = mBookModel.getBooks();

        for (Book book : listOfBooks) {
            System.out.println("ISBN: " + book.getISBNNumber()
                    + "\nTitle: " + book.getTitle()
                    + "\nYear: " + book.getYear()
                    + "\nAuthor: " + book.getAuthor()
                    + "\n");
        }
    }

    private boolean isDataValid() {
        return (!txtISBN.getText().isEmpty() && !txtTitle.getText().isEmpty()
                && !txtYear.getText().isEmpty() && !txtAuthor.getText().isEmpty());
    }

    private void clearTxtFields() {
        txtISBN.clear();
        txtTitle.clear();
        txtYear.clear();
        txtAuthor.clear();
    }

}
