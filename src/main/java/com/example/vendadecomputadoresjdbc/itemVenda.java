package com.example.vendadecomputadoresjdbc;

import java.util.List;

public class itemVenda {
    private String id;
    private int qtdVendida;
    private double valorVendido;
    private String vendaId;
    private String computadorId;
    private List<Computador> listaDeComputadores;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

    public double getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(double valorVendido) {
        this.valorVendido = valorVendido;
    }

    public String getVendaId() {
        return vendaId;
    }

    public void setVendaId(String vendaId) {
        this.vendaId = vendaId;
    }

    public String getComputadorId() {
        return computadorId;
    }

    public void setComputadorId(String computadorId) {
        this.computadorId = computadorId;
    }

    public List<Computador> getListaDeComputadores() {
        return listaDeComputadores;
    }

    public void setListaDeComputadores(List<Computador> listaDeComputadores) {
        this.listaDeComputadores = listaDeComputadores;
    }
}
