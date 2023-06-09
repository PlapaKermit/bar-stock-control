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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;


public class ManagementPageController {
    @FXML
    private TableView<Beer> beerTable;
    @FXML
    private TableColumn<Beer, String> beerNameColumn;
    @FXML
    private TableColumn<Beer, String> beerTypeColumn;
    @FXML
    private TableColumn<Beer, Double> beerAlcoholColumn;
    @FXML
    private TableColumn<Beer, Double> beerPriceColumn;
    @FXML
    private TableColumn<Beer, Integer> beerStockColumn;


   
    @FXML
    public void onAddButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/plapa_kermit/gestion_bar/BeerAdd-page.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void onBackButton(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/plapa_kermit/gestion_bar/Main-page.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

//    public void onMajButton(ActionEvent event) {
//        initialize();
//    }

    public void initialize() {
        beerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        beerTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        beerAlcoholColumn.setCellValueFactory(new PropertyValueFactory<>("alcohol"));
        beerPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        beerStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));

        // Load data from CSV file
        BeerList beerList = new BeerList();
        beerList.loadFromCSV("beerlist.csv");
        // Convert the ArrayList to an ObservableList
        ObservableList<Beer> beerData = FXCollections.observableArrayList(beerList.getBeersList());

        // Set the ObservableList as the data source for the TableView
        beerTable.setItems(beerData);
    }

    public void onSupButton(ActionEvent event) {
        // Get the selected item
        Beer selectedBeer = beerTable.getSelectionModel().getSelectedItem();

        // Remove the selected item from the ArrayList
        BeerList beerList = new BeerList();
        beerList.loadFromCSV("beerlist.csv");
        beerList.deleteBeerByName("beerlist.csv",selectedBeer.getName());
        //beerList.getBeersList().remove(selectedBeer.getName());

        // Save the ArrayList to the CSV file
        beerList.saveToCSV("beerlist.csv");

        // Refresh the TableView
        initialize();
    }
}
