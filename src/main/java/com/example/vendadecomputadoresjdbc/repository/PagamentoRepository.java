package com.example.vendadecomputadoresjdbc.repository;

import com.example.vendadecomputadoresjdbc.entities.Pagamento;
import com.example.vendadecomputadoresjdbc.entities.Venda;

import java.util.List;

public interface PagamentoRepository {



    public Pagamento buscar(Integer idVenda);

    public void insert(Pagamento pagamento);

    public void delete (Pagamento pagamento);

    public void update(Pagamento pagamento);

    public List<Pagamento> all(List<Pagamento> idsVenda);
}
