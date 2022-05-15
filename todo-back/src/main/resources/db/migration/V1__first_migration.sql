CREATE TABLE lista_de_tarefas (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(256) NOT NULL ,
    created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE tarefa (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(256) NOT NULL ,
    concluido BOOLEAN DEFAULT FALSE,
    descricao VARCHAR(1024),
    prioridade INT DEFAULT 2,

    lista_de_tarefas_id BIGINT NOT NULL,
    CONSTRAINT fk_lista_de_tarefas
        FOREIGN KEY(lista_de_tarefas_id)
        REFERENCES lista_de_tarefas(id)
        ON DELETE CASCADE
);

CREATE TABLE subtarefa (
    id BIGINT NOT NULL,
    nome VARCHAR(256) NOT NULL,
    concluido BOOLEAN DEFAULT FALSE,

    tarefa_id BIGINT NOT NULL,
    CONSTRAINT fk_tarefa
        FOREIGN KEY(tarefa_id)
        REFERENCES tarefa(id)
        ON DELETE CASCADE
);

CREATE TABLE tag (
    nome VARCHAR(256) NOT NULL,
    cor VARCHAR(6),

    tarefa_id BIGINT NOT NULL,
    CONSTRAINT fk_tarefa
        FOREIGN KEY(tarefa_id)
        REFERENCES tarefa(id)
        ON DELETE CASCADE
);