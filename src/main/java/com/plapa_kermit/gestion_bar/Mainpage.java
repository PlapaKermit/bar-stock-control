package com.plapa_kermit.gestion_bar;

import com.plapa_kermit.gestion_bar.Model.Beer;
import com.plapa_kermit.gestion_bar.Model.BeerList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
// Lance l'application
public class Mainpage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Mainpage.class.getResource("main-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        BeerList list = new BeerList();
        list.addBeer("Heineken", "Blonde", 5.0, 2.5, 10);
        list.saveToCSV("beerlist.csv");
        stage.setTitle("Bar Management");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}