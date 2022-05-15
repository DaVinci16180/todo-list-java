package com.todo.main.controller;

import com.todo.main.model.Subtarefa;
import com.todo.main.model.Tag;
import com.todo.main.model.Tarefa;
import com.todo.main.repository.TagRepository;
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
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping("/save")
    public ResponseEntity<JSONObject> save(@RequestBody HashMap<String, String> params) {
        if (!params.containsKey("nome") ||
            !params.containsKey("tarefaId")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Long tarefaId = Long.parseLong(params.get("tarefaId"));

        Optional<Tarefa> tarefa = tarefaRepository.findById(tarefaId);

        if (tarefa.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Tag tag = new Tag();
        tag.setNome(params.get("nome"));
        tag.setTarefa(tarefa.get());

        if (params.containsKey("id")) {
            tag.setId(Long.parseLong(params.get("id")));
        }

        if (params.containsKey("cor")) {
            tag.setCor(params.get("cor"));
        }

        tag = tagRepository.save(tag);

        JSONObject json = new JSONObject();
        json.appendField("data", tag);

        return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
    }

    @PostMapping("/list")
    public ResponseEntity<JSONArray> list(@RequestBody HashMap<String, Long> params) {
        Long tarefaId = params.get("tarefaId");
        List<Tag> all = tagRepository.findAllByTarefaId(tarefaId);
        JSONArray json = new JSONArray();

        json.addAll(all);

        return new ResponseEntity<JSONArray>(json, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<JSONObject> get(@PathVariable("id") Long id) {
        Optional<Tag> tag = tagRepository.findById(id);

        if (tag.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        JSONObject json = new JSONObject();
        json.appendField("data", tag.get());

        return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JSONObject> delete(@PathVariable("id") Long id) {
        Optional<Tag> tag = tagRepository.findById(id);

        if (tag.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tagRepository.delete(tag.get());

        JSONObject json = new JSONObject();
        json.appendField("success", true);

        return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
    }
}
