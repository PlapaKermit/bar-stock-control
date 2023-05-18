package com.plapa_kermit.gestion_bar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
// Lance l'application
public class Mainpage extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Mainpage.class.getResource("Main-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Bar Management");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}