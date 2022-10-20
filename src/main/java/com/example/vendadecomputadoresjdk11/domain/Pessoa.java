package com.example.vendadecomputadoresjdk11.domain;


import javax.persistence.*;
import java.util.UUID;

//@Entity
//@Table(name="pessoa")
public class Pessoa {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;

    public Pessoa(){};
    public UUID getId() {
        return id;
    }



    public String getCpf() {
        return cpf;
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

}
