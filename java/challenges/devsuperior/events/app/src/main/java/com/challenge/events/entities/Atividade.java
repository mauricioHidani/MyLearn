package com.challenge.events.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_atividades")
public class Atividade implements Serializable {

    @Serial private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column
    private Double preco;

    @ManyToMany(mappedBy = "atividades")
    private Set<Participante> participantes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "atividade")
    private Set<Bloco> blocos = new HashSet<>();

    protected Atividade() {
    }

    public Atividade(Integer id, String nome, String descricao, Double preco, Set<Participante> participantes,
                     Categoria categoria, Set<Bloco> blocos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.participantes = participantes;
        this.categoria = categoria;
        this.blocos = blocos;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Set<Bloco> getBlocos() {
        return blocos;
    }
}
