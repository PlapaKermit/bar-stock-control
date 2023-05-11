package com.plapa_kermit.gestion_bar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

//Si possible trier dans des packages Vue, Model , Controller

//DOIT QUE modifier
//Rajout une fonction qui affiche qqchose sur l'ecran
public class HelloController {
    @FXML
    public TextField nameField;
    @FXML //Rentre la vue interactive
    private Label welcomeText;
    @FXML private TextField tittel;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void onTestButtonClick(ActionEvent actionEvent) {
        welcomeText.setText("Test button clicked!");
    }

    @FXML
    protected void handleButton1Action(ActionEvent actionEvent) {
        System.out.println(nameField.getText());
    }
}