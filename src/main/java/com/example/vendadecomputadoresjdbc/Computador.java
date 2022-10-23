package com.example.vendadecomputadoresjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Computador {
    private String id;
    private String modelo;
    private  String processador;
    private String memoria;
    private String armazenamento;
    private String so;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public List<Computador> getComputadores(Connection conexao) throws SQLException {
        String sql = "select * from computador";
        List<Computador> listaDeComputadores = new ArrayList<Computador>();
        try {
            ResultSet resultSet = conexao.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                Computador computador = new Computador();
                computador.setId(resultSet.getString("id"));
                computador.setModelo(resultSet.getString("modelo"));
                computador.setProcessador(resultSet.getString("processador"));
                computador.setMemoria(resultSet.getString("memoria"));
                computador.setArmazenamento(resultSet.getString("armazenamento"));
                computador.setSo(resultSet.getString("armazenamento"));
                listaDeComputadores.add(computador);

                System.out.println(computador.getModelo());
               listaDeComputadores.add(computador);
               return  listaDeComputadores;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        conexao.close();
        return null;
    }

}
