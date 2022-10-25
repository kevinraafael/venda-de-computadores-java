module com.example.vendadecomputadoresjdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example.vendadecomputadoresjdbc to javafx.fxml;
    exports com.example.vendadecomputadoresjdbc;
    exports com.example.vendadecomputadoresjdbc.controllers;
    opens com.example.vendadecomputadoresjdbc.controllers to javafx.fxml;
    exports com.example.vendadecomputadoresjdbc.entities;
    opens com.example.vendadecomputadoresjdbc.entities to javafx.fxml;
}