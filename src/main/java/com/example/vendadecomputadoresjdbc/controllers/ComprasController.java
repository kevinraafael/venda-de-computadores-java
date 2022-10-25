package com.example.vendadecomputadoresjdbc.controllers;
import com.example.vendadecomputadoresjdbc.Conexao;
import com.example.vendadecomputadoresjdbc.entities.Computador;
import com.example.vendadecomputadoresjdbc.entities.ItemVenda;
import com.example.vendadecomputadoresjdbc.entities.Pagamento;
import com.example.vendadecomputadoresjdbc.entities.Venda;
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
        public void  finalizarCompra() throws SQLException, ClassNotFoundException {

                Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres","postgres","senha@123");
                conexao.realizaConexao();
                Pagamento pag = new Pagamento(100.3,66.6,1,"descricao");
                pag.insert(conexao.getConnection());
                Venda v = new Venda("5b6c3c52-eb0f-46cd-b13b-c3a2dcc7c5c2","105c63c9-51de-4542-90ee-92e1ee1c92be",1000,pag.getId());
                v.insert(conexao.getConnection());
                ItemVenda itemVenda = new ItemVenda(1,100,v.getId(),"7314581c-08ea-4370-91f2-3d40a5225863");
                itemVenda.insert(conexao.getConnection());
        }
}

