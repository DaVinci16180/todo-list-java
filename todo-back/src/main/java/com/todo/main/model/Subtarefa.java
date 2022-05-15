package com.todo.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Subtarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subtarefa_id_generator")
    @SequenceGenerator(name = "subtarefa_id_generator", sequenceName = "subtarefa_id_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private boolean concluido;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
