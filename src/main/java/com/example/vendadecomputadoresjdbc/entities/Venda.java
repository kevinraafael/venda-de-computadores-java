package com.example.vendadecomputadoresjdbc.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

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
        String sql = "INSERT INTO venda (funcionarioid,clienteid,valor,pagamentoid) VALUES(?,?,?,?)  RETURNING id";
        if(conexao != null){
            try {
                PreparedStatement prepare_statement = conexao.prepareStatement(sql);
                prepare_statement.setObject(1, UUID.fromString(this.funcionarioId));
                prepare_statement.setObject(2, UUID.fromString(this.clienteId));
                prepare_statement.setDouble(3, this.valor);
                prepare_statement.setObject(4, UUID.fromString(this.pagamentoId));
                System.out.println(prepare_statement);
                ResultSet set = prepare_statement.executeQuery();
                if(set.next()){
                    this.setId(set.getString(1));
                }

            }catch (Exception e){
                throw new RuntimeException(e);
            }

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
