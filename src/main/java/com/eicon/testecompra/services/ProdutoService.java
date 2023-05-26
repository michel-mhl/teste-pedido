package com.eicon.testecompra.services;

import com.eicon.testecompra.domain.Pedido;
import com.eicon.testecompra.domain.Produto;
import com.eicon.testecompra.repositories.PedidoRepository;
import com.eicon.testecompra.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto findById(Integer id) {
        Produto produto = produtoRepository.findById(id).get();
        return produto;
    }

    @Transactional
    public List<Produto> findAll() {
        List<Produto> list = produtoRepository.findAll();
        return list;
    }
}
