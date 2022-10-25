package com.example.vendadecomputadoresjdbc.controllers;
import com.example.vendadecomputadoresjdbc.Conexao;
import com.example.vendadecomputadoresjdbc.entities.Computador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ComprasController implements Initializable {
        @FXML
        private RadioButton formaPagamento;

        @FXML
        private ListView<Computador> lvComputador;


        private List<Computador> listaDeComputadores = new ArrayList<>();

        private ObservableList<Computador> obsListComputadores;

        @FXML
        private Label totalCarrinho;


        @Override
        public void initialize(URL url, ResourceBundle rb) {
                try {
                        carregaLista();
                } catch (SQLException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                }
        }

        public void carregaLista() throws SQLException, ClassNotFoundException {
                Computador comp = new Computador();
                Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres", "postgres",
                        "senha@123");
                conexao.realizaConexao();
                try {
                        // Trocar para lista do itemVenda, os computadores que o cliente escolheu,
                        //Por enquanto está com lista de computadores salva no banco
                        listaDeComputadores = comp.getComputadores(conexao.getConnection());
                        obsListComputadores = FXCollections.observableArrayList(listaDeComputadores);
                        lvComputador.setItems(obsListComputadores);
                        lvComputador.getItems().toString();

                } catch (Exception e) {
                 System.out.println(e.getMessage());
//            informationDialog( event, "Não foi possível carregar a lista de computadores",
//                    e.toString(), "Tente mais tarde");
                }
        }
        @FXML
        protected void informationDialogVenda(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sucesso!");
                alert.setHeaderText("Venda concluída com SUCESSO!");
                alert.setContentText("Pagamento á vista em dinheiro");
                alert.showAndWait();
        }

        @FXML
        protected void somaTotalValorList(){

        }
}

