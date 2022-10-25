package com.example.vendadecomputadoresjdbc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("CarrinhoDeCompras.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        launch();
//        Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres","postgres","senha@123");
//        conexao.realizaConexao();
//        itemVenda itemVenda = new itemVenda(1,100,"8796943a-73e8-41b1-88bb-a34464614187","7314581c-08ea-4370-91f2-3d40a5225863");
//        itemVenda.insert(conexao.getConnection());
    }

}