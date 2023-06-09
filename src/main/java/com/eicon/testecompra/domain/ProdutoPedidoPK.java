package com.eicon.testecompra.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ProdutoPedidoPK  implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Produto produto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoPedidoPK that)) return false;
        return Objects.equals(pedido, that.pedido) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedido, produto);
    }

}
