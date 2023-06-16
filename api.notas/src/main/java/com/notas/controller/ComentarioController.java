package com.notas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.notas.model.Comentario;
import com.notas.service.ComentarioService;

import java.util.List;

@RestController
@RequestMapping("/api_comentario")
public class ComentarioController {

    private final ComentarioService comentarioService;

    @Autowired
    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Comentario> createComentario(@RequestBody Comentario comentario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioService.createComentario(comentario));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Comentario>> getAllComentarios() {
        return ResponseEntity.status(HttpStatus.OK).body(comentarioService.getAllComentarios());
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Comentario> updateComentario(
            @PathVariable("id") Long id,
            @RequestBody Comentario comentario) {
        Comentario updatedComentario = comentarioService.updateComentario(id, comentario);
        if (updatedComentario != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedComentario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteComentario(@PathVariable("id") Long id) {
        comentarioService.deleteComentario(id);
        return ResponseEntity.ok("Comentário deletado com sucesso.");
    }
}
