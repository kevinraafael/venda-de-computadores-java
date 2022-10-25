package com.example.vendadecomputadoresjdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pessoa {
    private String id;
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;

    public String getCpf() {
        return cpf;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getId() {
        return id;
    }

    public Pessoa buscaPessoa(String cpf, Connection conexao) throws SQLException {

        String sql = "select id,cpf,nome,endereco,telefone from pessoa where cpf="+"'"+cpf+"'";
       // String sql = "select * from pessoa";
        System.out.println(sql);
        try {

            ResultSet resultSet = conexao.createStatement().executeQuery(sql);
            Pessoa pessoa = new Pessoa();
            if (resultSet.next()) {

                pessoa.setId(resultSet.getString("id"));
                pessoa.setCpf(resultSet.getString("cpf"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setEndereco(resultSet.getString("endereco"));
                pessoa.setTelefone(resultSet.getString("telefone"));

                System.out.println(pessoa.getNome());


            }
            return  pessoa;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
