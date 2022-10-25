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
        //launch();
        Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres","postgres","senha@123");
        conexao.realizaConexao();
        Pagamento p = new Pagamento(14787.6,0.0,1,"pix");
        p.insert(conexao.getConnection());
        Venda v = new Venda("5b6c3c52-eb0f-46cd-b13b-c3a2dcc7c5c2","105c63c9-51de-4542-90ee-92e1ee1c92be",1000,"5c4e494a-0c36-4734-b3ad-a84c196e3c72");
        v.insert(conexao.getConnection());
    }

}