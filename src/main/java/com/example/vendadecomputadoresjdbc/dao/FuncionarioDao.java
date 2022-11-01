package com.example.vendadecomputadoresjdbc.dao;

import com.example.vendadecomputadoresjdbc.entities.Cliente;
import com.example.vendadecomputadoresjdbc.repository.ClienteRepository;

import java.util.List;

public class FuncionarioDao  implements ClienteRepository {
    @Override
    public Cliente buscar(String cpfCliente) {
        return null;
    }

    @Override
    public void insert(Cliente cliente) {

    }

    @Override
    public void delete(Cliente cliente) {

    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public List<Cliente> all(List<String> cpfs) {
        return null;
    }
}
