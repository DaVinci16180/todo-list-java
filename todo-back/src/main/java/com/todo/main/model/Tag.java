package com.todo.main.model;

import javax.persistence.*;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_id_generator")
    @SequenceGenerator(name = "tag_id_generator", sequenceName = "tag_id_sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nome;
    private String cor;

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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
