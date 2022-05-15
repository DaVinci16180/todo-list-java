package com.todo.main.controller;

import com.todo.main.model.ListaDeTarefas;
import com.todo.main.repository.ListaDeTarefasRepository;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/listaDeTarefas")
public class ListaDeTarefasController {

    @Autowired
    private ListaDeTarefasRepository listaDeTarefasRepository;

    @PostMapping("/save")
    public ResponseEntity<JSONObject> save(@RequestBody HashMap<String, String> params) {
        ListaDeTarefas listaDeTarefas = new ListaDeTarefas();
        listaDeTarefas.setNome(params.get("nome"));

        if (params.containsKey("id")) {
            listaDeTarefas.setId(Long.parseLong(params.get("id")));
        }

        listaDeTarefas = listaDeTarefasRepository.save(listaDeTarefas);

        JSONObject json = new JSONObject();
        json.appendField("data", listaDeTarefas);

        return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<JSONArray> list() {
        List<ListaDeTarefas> all = listaDeTarefasRepository.findAll();
        JSONArray json = new JSONArray();

        json.addAll(all);

        return new ResponseEntity<JSONArray>(json, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<JSONObject> get(@PathVariable("id") Long id) {
        Optional<ListaDeTarefas> listaDeTarefas = listaDeTarefasRepository.findById(id);

        if (listaDeTarefas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        JSONObject json = new JSONObject();
        json.appendField("data", listaDeTarefas.get());

        return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSONObject> delete(@PathVariable("id") Long id) {
        Optional<ListaDeTarefas> listaDeTarefas = listaDeTarefasRepository.findById(id);

        if (listaDeTarefas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        listaDeTarefasRepository.delete(listaDeTarefas.get());

        JSONObject json = new JSONObject();
        json.appendField("success", true);

        return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
    }
}
