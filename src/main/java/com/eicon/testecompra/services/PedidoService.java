package com.eicon.testecompra.services;

import com.eicon.testecompra.domain.Pedido;
import com.eicon.testecompra.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public Pedido insert(Pedido obj) {
        obj.setId(null);
     /*   List<Produto> produtos = new ArrayList<>();
        List<ProdutosPedido> produtosPedidos = new ArrayList<>();
        for (ProdutosPedido produtosPedido : produtosPedidos) {

        }*/
        return pedidoRepository.save(obj);
    }



}