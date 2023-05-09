module com.plapa_kermit.gestion_bar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.plapa_kermit.gestion_bar to javafx.fxml;
    exports com.plapa_kermit.gestion_bar;
}