module com.example.clients {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.clients to javafx.fxml;
    exports com.example.clients;
}