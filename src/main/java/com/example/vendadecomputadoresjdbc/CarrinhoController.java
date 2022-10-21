package com.example.vendadecomputadoresjdbc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.sql.SQLException;

public class CarrinhoController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField cpfCliente;

    @FXML
    private  Label nomeCliente;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected  void  buscaCliente(ActionEvent event) throws SQLException, ClassNotFoundException {
        Pessoa p = new Pessoa();
        Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
        conexao.realizaConexao();
        Pessoa pessoa = new Pessoa();
        Cliente cliente = new Cliente();
        p.buscaPessoa(cpfCliente.getText(),conexao.getConnection());

        nomeCliente.setText(p.getNome());
        event.consume();
    }
}