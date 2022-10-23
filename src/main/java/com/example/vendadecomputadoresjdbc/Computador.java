package com.example.vendadecomputadoresjdbc;

public class Computador {
    private String codigo;
    private String modelo;
    private String processador;
    private String memoria;
    private String armazenamento;
    private String so;

    public Computador() {
    }

    public Computador(String codigo, String modelo, String processador, String memoria, String armazenamento,
            String so) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.processador = processador;
        this.memoria = memoria;
        this.armazenamento = armazenamento;
        this.so = so;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProcessador() {
        return this.processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoria() {
        return this.memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getArmazenamento() {
        return this.armazenamento;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getSo() {
        return this.so;
    }

    public void setSo(String so) {
        this.so = so;
    }
}
