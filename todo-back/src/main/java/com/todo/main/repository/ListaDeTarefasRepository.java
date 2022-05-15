package com.todo.main.repository;

import com.todo.main.model.ListaDeTarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDeTarefasRepository extends JpaRepository<ListaDeTarefas, Long> {
}
