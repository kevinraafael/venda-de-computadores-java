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

    private String computadorId;

    public String getVendaID() {
        return vendaID;
    }

    public void setVendaID(String vendaID) {
        this.vendaID = vendaID;
    }

    public String getComputadorId() {
        return computadorId;
    }

    public void setComputadorId(String computadorId) {
        this.computadorId = computadorId;
    }

    public itemVenda() {
    }

    public itemVenda(int qtdVendida, float valorVendido, String vendaId,String computadorId) {
        this.qtdVendida = qtdVendida;
        this.valorVendido = valorVendido;
        this.vendaID = vendaId;
        this.computadorId = computadorId;
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

    public itemVenda qtdVendida(int qtdVendida) {
        setQtdVendida(qtdVendida);
        return this;
    }

    public itemVenda valorVendido(float valorVendido) {
        setValorVendido(valorVendido);
        return this;
    }

    public void insert(Connection conexao) {
        String sql = "INSERT INTO itemvenda (qtdvendida, valorvendido, vendaid,computadorid) VALUES " +
        "('"+this.qtdVendida+"','"+this.valorVendido+"','"+this.vendaID+"','"+this.computadorId+"')";

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