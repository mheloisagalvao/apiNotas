package com.notas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.notas.model.AdicionarAmigo;
import com.notas.service.AdicionarAmigoService;

import java.util.List;

@RestController
@RequestMapping("/api_amigo")
public class AdicionarAmigoController {

    private final AdicionarAmigoService adicionarAmigoService;

    @Autowired
    public AdicionarAmigoController(AdicionarAmigoService adicionarAmigoService) {
        this.adicionarAmigoService = adicionarAmigoService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<AdicionarAmigo> createAdicionarAmigo(@RequestBody AdicionarAmigo adicionarAmigo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adicionarAmigoService.createAdicionarAmigo(adicionarAmigo));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<AdicionarAmigo>> getAllAdicionarAmigos() {
        return ResponseEntity.status(HttpStatus.OK).body(adicionarAmigoService.getAllAdicionarAmigos());
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<AdicionarAmigo> updateAdicionarAmigo(
            @PathVariable("id") Long id,
            @RequestBody AdicionarAmigo adicionarAmigo) {
        AdicionarAmigo updatedAdicionarAmigo = adicionarAmigoService.updateAdicionarAmigo(id, adicionarAmigo);
        if (updatedAdicionarAmigo != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedAdicionarAmigo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAdicionarAmigo(@PathVariable("id") Long id) {
        adicionarAmigoService.deleteAdicionarAmigo(id);
        return ResponseEntity.ok("Amigo e mensagem deletados com sucesso.");
    }
}
