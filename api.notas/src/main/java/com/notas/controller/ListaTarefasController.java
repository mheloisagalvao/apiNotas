package com.notas.controller;

import com.notas.model.ListaTarefas;
import com.notas.service.ListaTarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api_lista_tarefas")
public class ListaTarefasController {

    private final ListaTarefasService listaTarefasService;

    @Autowired
    public ListaTarefasController(ListaTarefasService listaTarefasService) {
        this.listaTarefasService = listaTarefasService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ListaTarefas> createListaTarefas(@RequestBody ListaTarefas listaTarefas) {
        return ResponseEntity.status(HttpStatus.CREATED).body(listaTarefasService.createListaTarefas(listaTarefas));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<ListaTarefas>> getAllListaTarefas() {
        return ResponseEntity.status(HttpStatus.OK).body(listaTarefasService.getAllListaTarefas());
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ListaTarefas> updateListaTarefas(
            @PathVariable("id") Long id,
            @RequestBody ListaTarefas listaTarefas) {
        ListaTarefas updatedListaTarefas = listaTarefasService.updateListaTarefas(id, listaTarefas);
        if (updatedListaTarefas != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedListaTarefas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteListaTarefas(@PathVariable("id") Long id) {
        listaTarefasService.deleteListaTarefas(id);
        return ResponseEntity.ok("Tarefa deletada com sucesso.");
    }

}
