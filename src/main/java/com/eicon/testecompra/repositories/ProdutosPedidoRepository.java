package com.eicon.testecompra.repositories;

import com.eicon.testecompra.domain.ProdutosPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosPedidoRepository extends JpaRepository<ProdutosPedido, Integer> {

    @Query(nativeQuery = true, value = """
    SELECT pe.ID, pe.DATA_CAD, pp.QUANTIDADE, pp.VALOR_TOTAL, pp.DESCONTO, p.ID, p.NOME, p.VALOR
    FROM PRODUTO p
    JOIN PRODUTOS_PEDIDO pp ON p.ID = pp.PRODUTO_ID
    JOIN PEDIDO pe ON pe.ID = pp.PEDIDO_ID
    WHERE pe.ID = :listId
""")
    List<ProdutosPedido> searchByList(Integer listId);

}
