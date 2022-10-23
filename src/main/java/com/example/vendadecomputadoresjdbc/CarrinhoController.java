package com.example.vendadecomputadoresjdbc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.sql.SQLException;

public class CarrinhoController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField cpfCliente;

    @FXML
    private Label nomeCliente;

    @FXML
    protected void buscaCliente(ActionEvent event) throws SQLException, ClassNotFoundException {
        Pessoa p = new Pessoa();
        Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres", "postgres",
                "1234");
        conexao.realizaConexao();
        Pessoa pessoa = new Pessoa();
        try {
            p.buscaPessoa(cpfCliente.getText(), conexao.getConnection());
            Cliente cliente = new Cliente();
            cliente.verificaSeECliente(cpfCliente.getText(), conexao);
            nomeCliente.setText(p.getNome());
            conexao.getConnection().close();
        } catch (Exception e) {
            informationDialog(event, "Ocorreu um erro", e.toString(),
                    "Por favor adicione o cliente");
        }


    }

    protected void informationDialog(ActionEvent event, String title, String headerText, String bottomText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(bottomText);
        alert.showAndWait();
    }

}