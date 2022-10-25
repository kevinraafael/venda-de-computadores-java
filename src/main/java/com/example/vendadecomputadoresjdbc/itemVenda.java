package com.example.vendadecomputadoresjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class itemVenda {
    private int qtdVendida;
    private float valorVendido;
    private String vendaID;
    private ArrayList<Computador> computadores = new ArrayList<>();

    public itemVenda() {
    }

    public itemVenda(int qtdVendida, float valorVendido, ArrayList<Computador> computadores) {
        this.qtdVendida = qtdVendida;
        this.valorVendido = valorVendido;
        this.computadores = computadores;
    }

    public int getQtdVendida() {
        return this.qtdVendida;
    }

    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    public float getValorVendido() {
        return this.valorVendido;
    }

    public void setValorVendido(float preco) {
        this.valorVendido = preco;
    }

    public ArrayList<Computador> getComputadores() {
        return this.computadores;
    }

    public void setComputadores(ArrayList<Computador> computadores) {
        this.computadores = computadores;
    }

    public itemVenda qtdVendida(int qtdVendida) {
        setQtdVendida(qtdVendida);
        return this;
    }

    public itemVenda valorVendido(float valorVendido) {
        setValorVendido(valorVendido);
        return this;
    }

    public itemVenda computadores(ArrayList<Computador> computadores) {
        setComputadores(computadores);
        return this;
    }

    public void insert(Connection conexao) {
        String sql = "INSERT INTO itemvenda (qtdvendida, valorvendido, vendaid) VALUES " +
        "('"+this.qtdVendida+"','"+this.valorVendido+"','"+this.vendaID+"')";
       
        List<ItemVenda> listaDeItemVendas = new ArrayList<ItemVenda>();
        try {
            ResultSet resultSet = conexao.createStatement().executeQuery(sql);
            System.out.println(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void criaItem() {
        
    }
}