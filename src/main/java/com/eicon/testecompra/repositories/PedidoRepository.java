package com.eicon.testecompra.repositories;

import com.eicon.testecompra.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

    @Query(nativeQuery = true, value = """
                     select pe.id,pe.data_cad,pp.quantidade,pp.valor_total,pp.desconto,p.id, p.nome,p.valor
                     from produtos_pedido pp
                     inner join produto p on(pp.produto_id = p.id)
                     inner join pedido pe on(pp.pedido_id = pe.id)
                     where pe.id = :listId
            """)
    List<Pedido> SearchByListId(Integer listId);
}
