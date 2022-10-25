package com.example.vendadecomputadoresjdbc.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

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
        String sql = "INSERT INTO pagamento (valortotal,desconto,parcelamento,descricao) VALUES (?,?,?,?)";
        if(conexao != null){
            try {
                PreparedStatement prepare_statement = conexao.prepareStatement(sql);
                prepare_statement.setDouble(1,this.valorTotal);
                prepare_statement.setDouble(2,this.desconto);
                prepare_statement.setInt(3, this.parcelamento);
                prepare_statement.setString(4,this.descricao);
                System.out.println(prepare_statement);
                prepare_statement.execute();
            }catch (Exception e){
                throw new RuntimeException(e);
            }

        }
    }
}
