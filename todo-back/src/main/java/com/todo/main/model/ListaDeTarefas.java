package com.todo.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lista_de_tarefas")
public class ListaDeTarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lista_de_tarefas_id_generator")
    @SequenceGenerator(name = "lista_de_tarefas_id_generator", sequenceName = "lista_de_tarefas_id_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "listaDeTarefas")
    private List<Tarefa> tarefas = new ArrayList<>();


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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
