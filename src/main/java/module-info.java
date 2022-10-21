module com.example.vendadecomputadoresjdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example.vendadecomputadoresjdbc to javafx.fxml;
    exports com.example.vendadecomputadoresjdbc;
}