package com.challenge.events.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_participantes")
public class Participante implements Serializable {

    @Serial private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "tb_participantes_atividades",
        joinColumns = @JoinColumn(name = "participante_id"),
        inverseJoinColumns = @JoinColumn(name = "atividade_id"))
    private Set<Atividade> atividades = new HashSet<>();

    protected Participante() {
    }

    public Participante(Integer id, String nome, String email, Set<Atividade> atividades) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.atividades = atividades;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Set<Atividade> getAtividades() {
        return atividades;
    }
}
