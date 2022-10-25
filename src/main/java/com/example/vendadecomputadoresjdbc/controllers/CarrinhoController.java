package com.example.vendadecomputadoresjdbc.controllers;

import com.example.vendadecomputadoresjdbc.MainApplication;
import com.example.vendadecomputadoresjdbc.entities.Cliente;
import com.example.vendadecomputadoresjdbc.entities.Computador;
import com.example.vendadecomputadoresjdbc.Conexao;
import com.example.vendadecomputadoresjdbc.entities.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import com.example.vendadecomputadoresjdbc.components.ComputadorComponent;

public class CarrinhoController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField cpfCliente;

    @FXML
    private Label nomeEncontrado ;
    @FXML
    private Label nomeCliente = new Label();


    @FXML
    private GridPane listaComputador;

    @FXML
    private Label totalCarrinho;

    @FXML
    private Label totalQntCarrinho;

    private final int numColunasLista = 3;

    /**
     * @param event
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @FXML
    protected void buscaCliente(ActionEvent event) throws SQLException, ClassNotFoundException {

         Pessoa p = new Pessoa();
         Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres",
         "postgres",
         "senha@123");
         conexao.realizaConexao();

         try {
         Pessoa pessoaEncontrada = p.buscaPessoa(cpfCliente.getText(), conexao.getConnection());
         Cliente cliente = new Cliente();
         cliente.verificaSeECliente(cpfCliente.getText(), conexao);
             nomeCliente.setText(pessoaEncontrada.getNome());
         conexao.getConnection().close();
         } catch (Exception e) {
         informationDialog(event, "Ocorreu um erro", e.toString(),
         "Por favor adicione o cliente");
         }

    }

    protected void informationDialog(ActionEvent event, String title, String headerText, String bottomText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(bottomText);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "senha@123");
            conexao.realizaConexao();
            List<Computador> computadores = new Computador().getComputadores(conexao.getConnection());

            for (int rowIndex = 0; rowIndex < 2; rowIndex++) {
                for (int collIndex = 0; collIndex < numColunasLista; collIndex++) {
                    int pcCollumns = (int) Math.floor((double) computadores.size() / numColunasLista);
                    int pcIndex = (rowIndex * pcCollumns) + collIndex;
                    if (pcIndex == computadores.size() - 1) {
                        String pcTitle = computadores.get(pcIndex).getModelo() + " "
                                + computadores.get(pcIndex).getProcessador();
                        String pcValor = computadores.get(pcIndex).getValor().toString();

                        listaComputador.add(
                                new ComputadorComponent("/assets/PC.jpg", pcTitle, pcValor,
                                        totalCarrinho, totalQntCarrinho),
                                collIndex, rowIndex);
                        return;
                    } else {
                        String pcTitle = computadores.get(pcIndex).getModelo() + " "
                                + computadores.get(pcIndex).getProcessador();
                        String pcValor = computadores.get(pcIndex).getValor().toString();

                        listaComputador.add(
                                new ComputadorComponent("/assets/PC.jpg", pcTitle, pcValor,
                                        totalCarrinho, totalQntCarrinho),
                                collIndex, rowIndex);
                    }

                }
            }

            conexao.getConnection().close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // throw e;
        }

    }

    @FXML
    protected void btnFinalizaVenda(ActionEvent e){
        MainApplication.trocaTela("compras");
    }

}