package com.example.vendadecomputadoresjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pagamento {

    private String id;
    private Double valorTotal;
    private Double desconto;
    private int parcelamento;
    private String descricao;



    public Pagamento(){

    }

    public Pagamento(Double valorTotal, Double desconto, int parcelamento, String descricao) {
        this.valorTotal = valorTotal;
        this.desconto = desconto;
        this.parcelamento = parcelamento;
        this.descricao = descricao;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void insert(Connection conexao){
        String sql = "INSERT INTO pagamento (valortotal,desconto,parcelamento,descricao) VALUES " +
                "('"+this.valorTotal+"','"+this.desconto+"','"+this.parcelamento+"','"+this.descricao+"')";
        try {
            ResultSet resultSet = conexao.createStatement().executeQuery(sql);
            this.setId(resultSet.getString("id"));
            if(resultSet.next()){
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
