package com.plapa_kermit.gestion_bar.Controller;

import com.plapa_kermit.gestion_bar.Model.Beer;
import com.plapa_kermit.gestion_bar.Model.BeerList;
import com.plapa_kermit.gestion_bar.Model.OrderItem;
import com.plapa_kermit.gestion_bar.Model.Order;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderPageController {
    @FXML
    private TextField StockNeeded;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField Name;

    @FXML
    public void onClickCommande(ActionEvent actionEvent) throws IOException {
        //Get info
        String stockNeeded = StockNeeded.getText();
        String selectedBeer = comboBox.getValue();
        String name = Name.getText();
        LocalDate date = LocalDate.now();

        //Create order
        BeerList beerList = new BeerList();
        beerList.loadFromCSV("beerlist.csv");
        ArrayList<Beer> beers = beerList.getBeersList();
        ArrayList<String> beerNames = new ArrayList<>();
        for (Beer beer : beers) {
            beerNames.add(beer.getName());
        }
        Beer beer = beers.get(beerNames.indexOf(selectedBeer));
        int quantity = Integer.parseInt(stockNeeded);
        OrderItem orderItem = new OrderItem(beer, quantity);
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        Order order = new Order(name, date.toString(), orderItems, "En cours");
        order.saveToCSV("orders.csv");

        //Go back to list
        onClickBack(actionEvent);
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
