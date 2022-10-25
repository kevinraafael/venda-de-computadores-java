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
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres","postgres","senha@123");
        conexao.realizaConexao();
        itemVenda p = new itemVenda(2,100,"4805372b-2ebf-40c1-a722-e5e3654f55db","7314581c-08ea-4370-91f2-3d40a5225863");
        p.insert(conexao.getConnection());
//        Venda v = new Venda("5b6c3c52-eb0f-46cd-b13b-c3a2dcc7c5c2","105c63c9-51de-4542-90ee-92e1ee1c92be",1000,"5c4e494a-0c36-4734-b3ad-a84c196e3c72");
//        v.insert(conexao.getConnection());
        launch();
        launch();
//        Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres","postgres","senha@123");
//        conexao.realizaConexao();
//        itemVenda itemVenda = new itemVenda(1,100,"8796943a-73e8-41b1-88bb-a34464614187","7314581c-08ea-4370-91f2-3d40a5225863");
//        itemVenda.insert(conexao.getConnection());
    }

}