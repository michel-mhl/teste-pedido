package com.eicon.testecompra.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate dataCad = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @OneToMany(mappedBy = "id.pedido")
    private Set<ProdutosPedido> produtosPedido = new HashSet<>();


    public Pedido(Integer id, LocalDate dataCad, Cliente cliente) {
        this.id = id;
        this.dataCad = (dataCad==null? LocalDate.now(): dataCad);
        this.cliente = cliente;

    }
    public Pedido() {
    }
}
