package com.challenge.events.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_categorias")
public class Categoria implements Serializable {

    @Serial private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private Set<Atividade> atividades = new HashSet<>();

    protected Categoria() {
    }

    public Categoria(Integer id, String descricao, Set<Atividade> atividades) {
        this.id = id;
        this.descricao = descricao;
        this.atividades = atividades;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }
}
