package com.example.vendadecomputadoresjdbc.components;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ComputadorComponent extends VBox {

    private ImageView imageView;

    private Label titulo;

    private Label valor;

    private Image imagem;

    private Button adicionarCarrinho;

    public ComputadorComponent(String imageUrl, String titulo, String valor, Label total, Label quantidade) {
        super();
        // Set image
        this.imagem = new Image(getClass().getResource(imageUrl).toExternalForm());
        this.imageView = new ImageView(this.imagem);

        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        // Set values
        this.titulo = new Label(titulo);
        this.valor = new Label(valor.toString());

        this.adicionarCarrinho = new Button("Adicionar no carrinho");
        this.adicionarCarrinho.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                adicionarNoCarrinho(total, quantidade);
            }
        });

        // Add nodes into VBox
        this.getChildren().add(this.imageView);
        this.getChildren().add(this.titulo);
        this.getChildren().add(this.valor);
        this.getChildren().add(this.adicionarCarrinho);

        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);
    }

    public void adicionarNoCarrinho(Label total, Label quantidade) {
        float valor = Float.parseFloat(this.valor.getText());
        float valorTotalAtual = Float.parseFloat(total.getText());
        String novoTotal = Float.toString(valor + valorTotalAtual);
        total.setText(novoTotal);
        int valorItensCarrinho = Integer.parseInt(quantidade.getText()) + 1;
        quantidade.setText(Integer.toString(valorItensCarrinho));
    }

}