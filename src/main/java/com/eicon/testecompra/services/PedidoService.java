package com.eicon.testecompra.services;

import com.eicon.testecompra.domain.Pedido;
import com.eicon.testecompra.domain.Produto;
import com.eicon.testecompra.domain.ProdutosPedido;
import com.eicon.testecompra.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public Pedido findById(Integer id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        return pedido;
    }

    @Transactional
    public List<Pedido> findAll() {
        List<Pedido> list = pedidoRepository.findAll();
        return list;
    }

    @Transactional() // argumento para garantir que a transação seja feita no modo leitura e nao escrita
    public List<Pedido> findByList(Integer listId) {
        List<Pedido>result = pedidoRepository.SearchByListId(listId);
        return result;
    }

    public Pedido insert(Pedido obj) {
        obj.setId(null);
        List<Produto> produtos = new ArrayList<>();
        List<ProdutosPedido>produtosPedidos = new ArrayList<>();
        for(ProdutosPedido produtosPedido :produtosPedidos){

        }
        return pedidoRepository.save(obj);
    }

}