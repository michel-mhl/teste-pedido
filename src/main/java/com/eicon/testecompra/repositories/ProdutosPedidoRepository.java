package com.eicon.testecompra.repositories;

import com.eicon.testecompra.domain.Pedido;
import com.eicon.testecompra.domain.ProdutosPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosPedidoRepository extends JpaRepository<ProdutosPedido,Integer> {
}
