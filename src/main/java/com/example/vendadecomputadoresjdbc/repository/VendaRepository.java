package com.example.vendadecomputadoresjdbc.repository;

import com.example.vendadecomputadoresjdbc.entities.Venda;

import java.util.List;

public interface VendaRepository {


    public Venda buscar(Integer codigo);

    public void insert(Venda v);

    public void delete (Venda venda);

    public void update(Venda v);


}
