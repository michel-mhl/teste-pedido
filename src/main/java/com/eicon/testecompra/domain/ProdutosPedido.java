package com.eicon.testecompra.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class ProdutosPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @JsonIgnore
    private ProdutoPedidoPK id = new ProdutoPedidoPK();

    private Double desconto;
    private Integer quantidade;
    private Double valorTotal;

    public ProdutosPedido() {
    }

    public ProdutosPedido(Pedido pedido,Produto produto, Double desconto, Integer quantidade, Double valorTotal) {
        this.id.setPedido(pedido);
        this.id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    @JsonIgnore
    public Pedido getPedido() {
        return id.getPedido();
    }
}
