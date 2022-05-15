package com.todo.main.model;

import com.todo.main.enums.Prioridade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarefa_id_generator")
    @SequenceGenerator(name = "tarefa_id_generator", sequenceName = "tarefa_id_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lista_de_tarefas_id")
    private ListaDeTarefas listaDeTarefas;

    @OneToMany(mappedBy = "tarefa")
    private List<Subtarefa> subtarefas;

    @OneToMany
    private List<Tag> tags;

    private String nome;
    private boolean concluido = false;
    private String descricao;
    private Prioridade prioridade = Prioridade.MEDIA;

    public ListaDeTarefas getListaDeTarefas() {
        return listaDeTarefas;
    }

    public void setListaDeTarefas(ListaDeTarefas listaDeTarefas) {
        this.listaDeTarefas = listaDeTarefas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Subtarefa> getSubtarefas() {
        return subtarefas;
    }

    public void setSubtarefas(List<Subtarefa> subtarefas) {
        this.subtarefas = subtarefas;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}
