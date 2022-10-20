module com.example.vendadecomputadoresjdk11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;


    opens com.example.vendadecomputadoresjdk11 to javafx.fxml;
    exports com.example.vendadecomputadoresjdk11;
}