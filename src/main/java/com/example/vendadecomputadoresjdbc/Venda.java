package com.example.vendadecomputadoresjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Venda {
    private String id;
    private String clienteId;
    private String funcionarioId;

    private String pagamentoId;

    public void setFormaPagamento(String pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public void setPagamentoId(String pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    private double valor;

    public Venda(String clienteId, String funcionarioId, double valor, String pagamentoId) {
        this.clienteId = clienteId;
        this.funcionarioId = funcionarioId;
        this.valor = valor;
        this.pagamentoId = pagamentoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setCliente(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionario(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public double getValor() {
        return valor;
    }

    public void setTotalVenda(double valor) {
        this.valor = valor;
    }

    /**
     * Inserir uma venda
     * @param conexao
     */
    public String insert(Connection conexao){
        String sql = "INSERT INTO venda (funcionarioid,clienteid,valor,pagamentoid) VALUES " +
                "('"+this.funcionarioId+"','"+this.clienteId+"','"+this.valor+"','"+this.pagamentoId+"')";
        try {
            ResultSet resultSet = conexao.createStatement().executeQuery(sql);
            this.id = resultSet.getString("id");
            System.out.println(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  this.id;
    }

    /**
     * Remover uma venda pelo id
     * @param conexao
     */
    public void delete(Connection conexao){
        String sql = "DELETE FROM venda WHERE id = '"+this.id+"' ";
        try {
            ResultSet resultSet = conexao.createStatement().executeQuery(sql);
            System.out.println(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
