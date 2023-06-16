package com.notas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.model.AdicionarAmigo;
import com.notas.repository.AdicionarAmigoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdicionarAmigoService {

    private final AdicionarAmigoRepository adicionarAmigoRepository;

    @Autowired
    public AdicionarAmigoService(AdicionarAmigoRepository adicionarAmigoRepository) {
        this.adicionarAmigoRepository = adicionarAmigoRepository;
    }

    public List<AdicionarAmigo> getAllAdicionarAmigos() {
        return adicionarAmigoRepository.findAll();
    }

    public AdicionarAmigo createAdicionarAmigo(AdicionarAmigo adicionarAmigo) {
        return adicionarAmigoRepository.save(adicionarAmigo);
    }

    public Optional<AdicionarAmigo> getAdicionarAmigoById(Long id) {
        return adicionarAmigoRepository.findById(id);
    }

    public AdicionarAmigo updateAdicionarAmigo(Long id, AdicionarAmigo adicionarAmigo) {
        Optional<AdicionarAmigo> amigoExistente = adicionarAmigoRepository.findById(id);
        if (amigoExistente.isPresent()) {
            AdicionarAmigo amigo = amigoExistente.get();
            amigo.setUserAmigo(adicionarAmigo.getUserAmigo());
            amigo.setMensagemAmigo(adicionarAmigo.getMensagemAmigo());
            return adicionarAmigoRepository.save(amigo);
        }
        return null;
    }

    public void deleteAdicionarAmigo(Long id) {
        adicionarAmigoRepository.deleteById(id);
    }
}
