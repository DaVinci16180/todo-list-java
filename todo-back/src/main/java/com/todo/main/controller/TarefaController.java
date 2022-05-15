package com.todo.main.controller;

import com.todo.main.enums.Prioridade;
import com.todo.main.model.ListaDeTarefas;
import com.todo.main.model.Tarefa;
import com.todo.main.repository.ListaDeTarefasRepository;
import com.todo.main.repository.TarefaRepository;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ListaDeTarefasRepository listaDeTarefasRepository;

    @PostMapping("/save")
    public ResponseEntity<JSONObject> save(@RequestBody HashMap<String, String> params) {
        if (!params.containsKey("listaDeTarefasId") ||
            !params.containsKey("nome")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Long listaDeTarefasId = Long.parseLong(params.get("listaDeTarefasId"));

        Optional<ListaDeTarefas> listaDeTarefas = listaDeTarefasRepository.findById(listaDeTarefasId);

        if (listaDeTarefas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Tarefa tarefa = new Tarefa();
        tarefa.setNome(params.get("nome"));
        tarefa.setListaDeTarefas(listaDeTarefas.get());
        tarefa.setDescricao(params.get("descricao"));

        if (params.containsKey("id")) {
            tarefa.setId(Long.parseLong(params.get("id")));
        }

        if (params.containsKey("concluido")) {
            tarefa.setConcluido(Boolean.getBoolean(params.get("concluido")));
        }

        if (params.containsKey("prioridade")) {
            tarefa.setPrioridade(Prioridade.valueOf(params.get("prioridade")));
        }

        tarefa = tarefaRepository.save(tarefa);

        JSONObject json = new JSONObject();
        json.appendField("data", tarefa);

        return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity<JSONArray> list(@RequestBody HashMap<String, Long> params) {
        Long listaDeTarefasId = params.get("listaDeTarefasId");
        List<Tarefa> all = tarefaRepository.findAllByListaDeTarefasId(listaDeTarefasId);
        JSONArray json = new JSONArray();

        json.addAll(all);

        return new ResponseEntity<JSONArray>(json, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<JSONObject> get(@PathVariable("id") Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        if (tarefa.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        JSONObject json = new JSONObject();
        json.appendField("data", tarefa.get());

        return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSONObject> delete(@PathVariable("id") Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        if (tarefa.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tarefaRepository.delete(tarefa.get());

        JSONObject json = new JSONObject();
        json.appendField("success", true);

        return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
    }
}
