package com.example.vendadecomputadoresjdbc.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class ItemVenda {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String id;
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

    public ItemVenda() {
    }

    public ItemVenda(int qtdVendida, float valorVendido, String vendaId, String computadorId) {
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

    public ItemVenda qtdVendida(int qtdVendida) {
        setQtdVendida(qtdVendida);
        return this;
    }

    public ItemVenda valorVendido(float valorVendido) {
        setValorVendido(valorVendido);
        return this;
    }

    public void insert(Connection conexao) {
        String sql = "INSERT INTO itemvenda (qtdvendida, valorvendido, vendaid,computadorid) VALUES (?,?,?,?)  RETURNING id";

        if (conexao != null) {
            try {
                PreparedStatement prepare_statement = conexao.prepareStatement(sql);
                prepare_statement.setInt(1, this.qtdVendida);
                prepare_statement.setDouble(2, this.valorVendido);
                prepare_statement.setObject(3, UUID.fromString(this.vendaID));
                prepare_statement.setObject(4, UUID.fromString(this.computadorId));
                System.out.println(prepare_statement);
                ResultSet set = prepare_statement.executeQuery();
                if(set.next()){
                    this.setId(set.getString(1));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}