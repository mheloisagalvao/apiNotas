package com.notas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notas.exceptions.NotFoundEntityException;
import com.notas.model.Cadastro;
import com.notas.repository.CadastroRepository;

import java.util.List;


@Service
public class CadastroService {

	@Autowired
    private final CadastroRepository cadastroRepository;

    public List<Cadastro> getAllCadastros() {
        return cadastroRepository.findAll();
    }
    
    public Cadastro getCadastroById(Long id) throws NotFoundEntityException {
		return cadastroRepository.findById(id).orElseThrow(() -> 
		new NotFoundEntityException("Cadastro não encontrado"));
	}

    public Cadastro createCadastro(Cadastro cadastro) {
         return cadastroRepository.save(cadastro);
    }
    
	public Object updateCadastro(Long id, Cadastro cadastro) {
		Cadastro existingCadastro = cadastroRepository.findById(id) 
				.orElseThrow();
		existingCadastro.setId(cadastro.getId());

		return cadastroRepository.save(existingCadastro);
	}
	
	public Cadastro updateCadastro(Cadastro updatedCadastro) {
	    return cadastroRepository.save(updatedCadastro);
	}

	public void deleteCadastroById(Long id) {
	    cadastroRepository.deleteById(id);
	}

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

}

