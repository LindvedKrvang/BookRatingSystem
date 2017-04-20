/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookratingsystem.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Rasmus
 */
public class MainViewController implements Initializable {

    @FXML
    private Button btnAdmin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleAdminButton(ActionEvent event) throws IOException {
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
