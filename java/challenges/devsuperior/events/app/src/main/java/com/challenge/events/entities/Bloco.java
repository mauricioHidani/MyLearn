package com.challenge.events.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_blocos")
public class Bloco implements Serializable {

    @Serial private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant inicio;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant fim;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;

    protected Bloco() {
    }

    public Bloco(Integer id, Instant inicio, Instant fim, Atividade atividade) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.atividade = atividade;
    }

    public Integer getId() {
        return id;
    }

    public Instant getInicio() {
        return inicio;
    }

    public Instant getFim() {
        return fim;
    }

    public Atividade getAtividade() {
        return atividade;
    }
}
