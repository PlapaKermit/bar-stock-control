module com.plapa_kermit.gestion_bar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.plapa_kermit.gestion_bar to javafx.fxml;
    exports com.plapa_kermit.gestion_bar;
    exports com.plapa_kermit.gestion_bar.Model;
    opens com.plapa_kermit.gestion_bar.Model to javafx.fxml;
    exports com.plapa_kermit.gestion_bar.Controller;
    opens com.plapa_kermit.gestion_bar.Controller to javafx.fxml;
}