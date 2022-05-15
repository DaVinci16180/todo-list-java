package com.todo.main.service;

import com.todo.main.repository.ListaDeTarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaDeTarefasService {

    @Autowired
    private ListaDeTarefasRepository listaDeTarefasRepository;

}
