package com.plapa_kermit.gestion_bar.Controller;

import com.plapa_kermit.gestion_bar.Model.Beer;
import com.plapa_kermit.gestion_bar.Model.BeerList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class OrderPageController {
    @FXML
    private TextField StockNeeded;
    @FXML
     private ComboBox<String> comboBox;

    @FXML
    public void onClickCommande(ActionEvent actionEvent) throws IOException {
        //Get info
        String stockNeeded = StockNeeded.getText();
        String selectedBeer = comboBox.getValue();
    }
    @FXML
    public void onClickBack(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/plapa_kermit/gestion_bar/List-page.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        BeerList beerList = new BeerList();
        beerList.loadFromCSV("beerlist.csv");
        ArrayList<Beer> beers = beerList.getBeersList();
        ArrayList<String> beerNames = new ArrayList<>();
        for (Beer beer : beers) {
            beerNames.add(beer.getName());
        }

        //ObservableList
        ObservableList<String> beerData = FXCollections.observableArrayList(beerNames);

        // Set the ObservableList as the items for the ComboBox
        comboBox.setItems(beerData);


    }
}
