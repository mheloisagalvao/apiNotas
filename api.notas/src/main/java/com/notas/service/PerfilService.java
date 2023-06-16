package com.notas.service;

import com.notas.model.Perfil;
import com.notas.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    private final PerfilRepository perfilRepository;

    @Autowired
    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public Perfil createPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public List<Perfil> getAllPerfis() {
        return perfilRepository.findAll();
    }

    public Perfil updatePerfil(Long perfilId, Perfil perfil) {
        Perfil existingPerfil = perfilRepository.findById(perfilId).orElse(null);
        if (existingPerfil != null) {
            existingPerfil.setUsername(perfil.getUsername());
            existingPerfil.setBiografia(perfil.getBiografia());
            existingPerfil.setIdade(perfil.getIdade());
            return perfilRepository.save(existingPerfil);
        }
        return null;
    }

    public void deletePerfil(Long perfilId) {
        perfilRepository.deleteById(perfilId);
    }
}
