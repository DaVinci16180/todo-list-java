package com.todo.main.repository;

import com.todo.main.model.Subtarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtarefaRepository extends JpaRepository<Subtarefa, Long> {
    List<Subtarefa> findAllByTarefaId(Long tarefaId);
}
