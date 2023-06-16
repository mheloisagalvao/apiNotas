package com.notas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.notas.model.Perfil;
import com.notas.service.PerfilService;

@RestController
@RequestMapping("/api_perfil")
public class PerfilController {

    private final PerfilService perfilService;

    @Autowired
    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Perfil> createPerfil(@RequestBody Perfil perfil) {
        return ResponseEntity.status(HttpStatus.OK).body(perfilService.createPerfil(perfil));
    }
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Perfil>> getAllPerfis() {
        return ResponseEntity.status(HttpStatus.OK).body(perfilService.getAllPerfis());
    }
    
    @RequestMapping(value = "/update/{perfilId}", method = RequestMethod.PUT)
    public ResponseEntity<Perfil> updatePerfil(
            @PathVariable(value = "perfilId") Long perfilId,
            @RequestBody Perfil perfil) {
        return ResponseEntity.status(HttpStatus.OK).body(perfilService.updatePerfil(perfilId, perfil));
    }
    
    @RequestMapping(value = "/delete/{perfilId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePerfil(@PathVariable(value = "perfilId") Long id) {
        perfilService.deletePerfil(id);
        return ResponseEntity.status(HttpStatus.OK).body("Perfil deletado com sucesso.");
    }
}
