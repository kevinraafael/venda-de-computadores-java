package com.example.vendadecomputadoresjdbc.controllers;
import com.example.vendadecomputadoresjdbc.Conexao;
import com.example.vendadecomputadoresjdbc.entities.Computador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ComprasController {
        @FXML
        private RadioButton formaPagamento;

        @FXML
        private ListView<Computador> lvComputador;


        private List<Computador> listaDeComputadores = new ArrayList<>();

        private ObservableList<Computador> obsListComputadores;



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
                        "1234");
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
}

