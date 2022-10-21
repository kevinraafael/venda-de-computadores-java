package com.example.vendadecomputadoresjdbc;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {
    private String id;
    private Pessoa pessoa = new Pessoa();

    public String getId() {

        return id;
    }
    public boolean verificaSeECliente(String cpf, Conexao conexao) throws SQLException {
        Pessoa pessoaEncontrada = pessoa.buscaPessoa(cpf, conexao.getConnection());
        boolean ehCliente = false;
        if (pessoa != null) {
            //Verifico se o meu cliente tem um id de pessoa, pois dessa
            //forma sei que ele é um cliente cadastrado
            String sql = "select pessoaid from cliente where pessoaid=" + "'" + pessoaEncontrada.getId() + "'";
            conexao.realizaConexao();
            ResultSet resultSet = conexao.getConnection().createStatement().executeQuery(sql);
            conexao.getConnection().close();
            if (resultSet.next() && resultSet.getString("pessoaid").equals(pessoaEncontrada.getId())) {
                Cliente cliente = new Cliente();
                ehCliente = true;
            }
            System.out.println(ehCliente);
            return ehCliente;
        } else {
            System.out.println("NÂO é cliente");
        }
        return ehCliente;
    }
}
