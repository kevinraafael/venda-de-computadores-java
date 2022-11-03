package com.example.spring.entities;

import javax.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
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


}
