package com.notas.service;

import com.notas.model.Comentario;
import com.notas.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario createComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    public Comentario updateComentario(Long id, Comentario comentario) {
        Comentario existingComentario = comentarioRepository.findById(id).orElse(null);
        if (existingComentario != null) {
            existingComentario.setComentario(comentario.getComentario());
            return comentarioRepository.save(existingComentario);
        }
        return null;
    }

    public void deleteComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}
