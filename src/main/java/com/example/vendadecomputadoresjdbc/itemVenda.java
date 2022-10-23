package com.example.vendadecomputadoresjdbc;

import java.util.ArrayList;

public class ItemVenda {
    private int qtdVendida;
    private float valorVendido;
    private ArrayList<Computador> computadores = new ArrayList<>();

    public ItemVenda() {
    }

    public ItemVenda(int qtdVendida, float valorVendido, ArrayList<Computador> computadores) {
        this.qtdVendida = qtdVendida;
        this.valorVendido = valorVendido;
        this.computadores = computadores;
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

    public ArrayList<Computador> getComputadores() {
        return this.computadores;
    }

    public void setComputadores(ArrayList<Computador> computadores) {
        this.computadores = computadores;
    }

    public ItemVenda qtdVendida(int qtdVendida) {
        setQtdVendida(qtdVendida);
        return this;
    }

    public ItemVenda valorVendido(float valorVendido) {
        setValorVendido(valorVendido);
        return this;
    }

    public ItemVenda computadores(ArrayList<Computador> computadores) {
        setComputadores(computadores);
        return this;
    }

    // TODO
    public void criaItem() {

    }
}
