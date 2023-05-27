package com.eicon.testecompra.services;

import com.eicon.testecompra.domain.ProdutosPedido;
import com.eicon.testecompra.repositories.ProdutosPedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosPedidoService {
    @Autowired
    private ProdutosPedidoRepository produtosPedidoRepository;


        @Transactional
        public List<ProdutosPedido> searchByList(Integer id) {
           List<ProdutosPedido> produtosPedido = produtosPedidoRepository.searchByList(id);

            return produtosPedido;
        }
    @Transactional
    public List<ProdutosPedido> findAll() {
        List<ProdutosPedido> list = produtosPedidoRepository.findAll();
        return list;
    }



/*    public Double calcularValor(ProdutosPedido obj) {
        double valor = 0;
        for (ProdutosPedido produtosPedido : obj) {
            valor += produtosPedido.getId().getProduto().getValor() * produtosPedido.getQuantidade(); ;
        }
        return valor ;
    }*/

}
