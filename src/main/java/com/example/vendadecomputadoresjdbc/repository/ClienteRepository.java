package com.example.vendadecomputadoresjdbc.repository;

import com.example.vendadecomputadoresjdbc.entities.Cliente;

import java.util.List;

public interface ClienteRepository {

    public Cliente buscar(String cpfCliente);

    public void insert(Cliente cliente);

    public void delete (Cliente cliente);

    public void update(Cliente cliente);

    public List<Cliente> all(List<String> cpfs);

}
