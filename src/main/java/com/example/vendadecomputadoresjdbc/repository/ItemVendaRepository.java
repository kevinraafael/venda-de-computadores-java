package com.example.vendadecomputadoresjdbc.repository;

import com.example.vendadecomputadoresjdbc.entities.ItemVenda;

import java.util.List;
import java.util.UUID;

public interface ItemVendaRepository {


    public ItemVenda buscar(UUID idVenda);

    public void insert(ItemVenda item);

    public void delete (ItemVenda itemVenda);

    public void update(ItemVenda itemVenda);

    public List<ItemVenda> all(List<UUID> idsVenda);

}
