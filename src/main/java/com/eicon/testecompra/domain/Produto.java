package com.eicon.testecompra.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Double valor;

    @OneToMany(mappedBy = "id.produto")
  //  @JsonIgnore
    private Set<ProdutosPedido> produtosPedidos = new HashSet<>();

    public Produto() {
    }

    public Produto(Integer id, String nome, Double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = (valor == null) ? 0.00 : valor;
    }


    @JsonIgnore
    public List<Pedido> getPedidos() {
        List<Pedido> lista = new ArrayList<>();
        for (ProdutosPedido x : produtosPedidos) {
            lista.add(x.getPedido());
        }
        return lista;
    }
}
