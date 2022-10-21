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
     //   launch();
        Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
        conexao.realizaConexao();
        Pessoa p = new Pessoa();
        Cliente cliente = new Cliente();
       // p.buscaPessoa("5454",conexao.getConnection());
        cliente.verificaSeECliente("5555555",conexao);
//

    }

}