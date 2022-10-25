package com.example.vendadecomputadoresjdbc;

import com.example.vendadecomputadoresjdbc.entities.ItemVenda;
import com.example.vendadecomputadoresjdbc.entities.Pagamento;
import com.example.vendadecomputadoresjdbc.entities.Venda;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class MainApplication extends Application {

    private static Stage stage;

    private static Scene carrinhoScene;
    private static Scene compraScene;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("CarrinhoDeCompras.fxml"));

        Parent fxmlCarrinho = FXMLLoader.load(getClass().getResource("CarrinhoDeCompras.fxml"));
        carrinhoScene = new Scene(fxmlCarrinho);

        Parent fxmlCompras = fxmlLoader.load(getClass().getResource("Compras.fxml"));
        compraScene = new Scene(fxmlCompras);

        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Hello!");
        stage.setScene(carrinhoScene);
        stage.show();

    }
    public static void trocaTela(String scr){
        switch (scr){
            case "carrinho":
                stage.setScene(carrinhoScene);
                break;
            case "compras":
                stage.setScene(compraScene);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres","postgres","senha@123");
        conexao.realizaConexao();
//        itemVenda p = new itemVenda(2,100,"4805372b-2ebf-40c1-a722-e5e3654f55db","7314581c-08ea-4370-91f2-3d40a5225863");
//        p.insert(conexao.getConnection());
//

//        Conexao conexao = new Conexao("jdbc:postgresql://localhost:5432/postgres","postgres","senha@123");
//        conexao.realizaConexao();
//        ItemVenda itemVenda = new ItemVenda(1,100,"8796943a-73e8-41b1-88bb-a34464614187","7314581c-08ea-4370-91f2-3d40a5225863");
//        itemVenda.insert(conexao.getConnection());
        Pagamento pag = new Pagamento(100.3,66.6,1,"descricao");
        pag.insert(conexao.getConnection());
        Venda v = new Venda("5b6c3c52-eb0f-46cd-b13b-c3a2dcc7c5c2","105c63c9-51de-4542-90ee-92e1ee1c92be",1000,pag.getId());
        v.insert(conexao.getConnection());
//        itemVenda itemVenda = new itemVenda(1,100,v.getId(),"7314581c-08ea-4370-91f2-3d40a5225863");
//        itemVenda.insert(conexao.getConnection());
        launch();
    }

}