package com.notas.service;

import com.notas.model.ListaTarefas;
import com.notas.repository.ListaTarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaTarefasService {

    private final ListaTarefasRepository listaTarefasRepository;

    @Autowired
    public ListaTarefasService(ListaTarefasRepository listaTarefasRepository) {
        this.listaTarefasRepository = listaTarefasRepository;
    }

    public ListaTarefas createListaTarefas(ListaTarefas listaTarefas) {
        return listaTarefasRepository.save(listaTarefas);
    }

    public List<ListaTarefas> getAllListaTarefas() {
        return listaTarefasRepository.findAll();
    }

    public ListaTarefas getListaTarefasById(Long id) {
        Optional<ListaTarefas> listaTarefasOptional = listaTarefasRepository.findById(id);
        return listaTarefasOptional.orElse(null);
    }

    public ListaTarefas updateListaTarefas(Long id, ListaTarefas listaTarefas) {
        Optional<ListaTarefas> listaTarefasOptional = listaTarefasRepository.findById(id);
        if (listaTarefasOptional.isPresent()) {
            ListaTarefas existingListaTarefas = listaTarefasOptional.get();
            existingListaTarefas.setNumTarefa(listaTarefas.getNumTarefa());
            existingListaTarefas.setDescricaoTarefa(listaTarefas.getDescricaoTarefa());
            existingListaTarefas.setPrioridadeTarefa(listaTarefas.getPrioridadeTarefa());
            return listaTarefasRepository.save(existingListaTarefas);
        }
        return null;
    }

    public void deleteListaTarefas(Long id) {
        listaTarefasRepository.deleteById(id);
    }

}
