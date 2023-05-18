package com.plapa_kermit.gestion_bar.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import com.plapa_kermit.gestion_bar.Model.BeerList;
import javafx.stage.Stage;

import java.io.IOException;


public class BeerAddPageController {
    //Import the text fields from the fxml file and the combo box
    @FXML
    private ComboBox<String> BeerType;
    @FXML
    private TextField BeerName;
    @FXML
    private TextField BeerPrice;
    @FXML
    private TextField BeerStock;
    @FXML
    private TextField BeerAlcohol;


    public void onClickSave(ActionEvent actionEvent) throws IOException {
        //Get the values from the text fields and the combo box
        String name = BeerName.getText();
        String type = BeerType.getValue();
        double price = Double.parseDouble(BeerPrice.getText());
        int stock = Integer.parseInt(BeerStock.getText());
        double alcohol = Double.parseDouble(BeerAlcohol.getText());

        //Create a new beer with the values
        BeerList BeerList = new BeerList();
        BeerList.loadFromCSV("beerlist.csv");
        BeerList.addBeer(name, type, alcohol, price, stock);
        BeerList.saveToCSV("beerlist.csv");

        //Go back to the previous page
        Parent root = FXMLLoader.load(getClass().getResource("/com/plapa_kermit/gestion_bar/Management-page.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void onClickBack(ActionEvent actionEvent) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/com/plapa_kermit/gestion_bar/Management-page.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
