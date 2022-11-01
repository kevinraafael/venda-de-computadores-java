package com.example.vendadecomputadoresjdbc.repository;

import com.example.vendadecomputadoresjdbc.entities.Funcionario;
import com.example.vendadecomputadoresjdbc.entities.Pessoa;

public  interface  PessoaRepository {

    public Pessoa buscar(String cpf);

    public void insert(Pessoa pessoa);

    public void delete (Pessoa pessoa);

    public void update(Pessoa pessoa);

}
