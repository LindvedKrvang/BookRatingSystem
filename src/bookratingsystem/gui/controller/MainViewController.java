/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.gui.controller;

import bookratingsystem.be.User;
import bookratingsystem.gui.model.UserModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Rasmus
 */
public class MainViewController implements Initializable {

    @FXML
    private Button btnAdmin;
    @FXML
    private ListView<User> lstUsers;
    @FXML
    private ListView<?> lstRatings;

    private final UserModel mUserModel;

    public MainViewController() {
        mUserModel = UserModel.getInstance();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setCellFactory();
        lstUsers.setItems(mUserModel.getListOfUsers());
    }

    /**
     * Sets the cellFactory for the list of Users.
     */
    private void setCellFactory() {
        lstUsers.setCellFactory(u -> new ListCell<User>() {
            @Override
            protected void updateItem(User item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });
    }

    @FXML
    private void handleAdminButton() throws IOException {
        Stage primStage = (Stage) btnAdmin.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/bookratingsystem/gui/view/AdminView.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primStage);

        stage.show();
    }

}
