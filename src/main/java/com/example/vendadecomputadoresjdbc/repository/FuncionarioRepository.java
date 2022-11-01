package com.example.vendadecomputadoresjdbc.repository;

import com.example.vendadecomputadoresjdbc.dao.FuncionarioDao;
import com.example.vendadecomputadoresjdbc.entities.Funcionario;
import com.example.vendadecomputadoresjdbc.entities.Venda;

public interface FuncionarioRepository {


    public Funcionario buscar(Integer matricula);

    public Funcionario buscar(String cpf);

    public void insert(Funcionario funcionario);

    public void delete (Funcionario funcionario);

    public void update(Funcionario funcionario);

}
