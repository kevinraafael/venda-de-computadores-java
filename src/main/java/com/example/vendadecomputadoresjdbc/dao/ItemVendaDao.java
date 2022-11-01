package com.example.vendadecomputadoresjdbc.dao;

import com.example.vendadecomputadoresjdbc.entities.ItemVenda;
import com.example.vendadecomputadoresjdbc.repository.ItemVendaRepository;

import java.util.List;
import java.util.UUID;

public class ItemVendaDao implements ItemVendaRepository {
    @Override
    public ItemVenda buscar(UUID idVenda) {
        return null;
    }

    @Override
    public void insert(ItemVenda item) {

    }

    @Override
    public void delete(ItemVenda itemVenda) {

    }

    @Override
    public void update(ItemVenda itemVenda) {

    }

    @Override
    public List<ItemVenda> all(List<UUID> idsVenda) {
        return null;
    }
}
