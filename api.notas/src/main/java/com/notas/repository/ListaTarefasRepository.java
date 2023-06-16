package com.notas.repository;

import com.notas.model.ListaTarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaTarefasRepository extends JpaRepository<ListaTarefas, Long> {
}
