package com.eicon.testecompra.resources;


import com.eicon.testecompra.domain.ProdutosPedido;
import com.eicon.testecompra.services.ProdutosPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produto-pedido")
public class ProdutosPedidoResource {
    @Autowired
    private ProdutosPedidoService produtosPedidoService;

    @GetMapping(value = "/{id}")
    public List<ProdutosPedido> searchByList(@PathVariable Integer id) {
        List<ProdutosPedido> obj = produtosPedidoService.searchByList(id);
        return obj;
    }

    @GetMapping()
    public List<ProdutosPedido> findAll() {
        List<ProdutosPedido> list = produtosPedidoService.findAll();
        return list;
    }


}
