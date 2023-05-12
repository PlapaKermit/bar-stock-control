package com.plapa_kermit.gestion_bar;

//Si possible trier dans des packages Vue, Model , Controller

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;


public class MainPageController {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private void onClickNext(ActionEvent event) throws IOException {
        String selectedRole = comboBox.getValue();
        if (selectedRole == null) {
            // User has not selected a role, so do nothing
            return;
        }

        String resource;
        switch (selectedRole) {
            case "Client":
                resource = "Achat-page.fxml";
                break;
            case "Livreur":
                resource = "Delivery-page.fxml";
                break;
            case "Gérant":
                resource = "Management-page.fxml";
                break;
            default:
                throw new IllegalArgumentException("Invalid role selected: " + selectedRole);
        }

        Parent root = FXMLLoader.load(getClass().getResource(resource));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}