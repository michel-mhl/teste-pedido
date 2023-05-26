package com.eicon.testecompra.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime dataCad = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "cliente.id")
    private Cliente cliente;


    @OneToMany(mappedBy = "id.pedido")
    private Set<ProdutosPedido> produtosPedido = new HashSet<>();


    public Pedido(Integer id, LocalDateTime dataCad, Cliente cliente) {
        this.id = id;
        this.dataCad = (dataCad==null? LocalDateTime.now(): dataCad);
        this.cliente = cliente;

    }
    public Pedido() {
    }
}
