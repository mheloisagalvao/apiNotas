package com.notas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AdicionarAmigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userAmigo;
    private String mensagemAmigo;
    
	public String getUserAmigo() {
		return userAmigo;
	}
	public void setUserAmigo(String userAmigo) {
		this.userAmigo = userAmigo;
	}
	public String getMensagemAmigo() {
		return mensagemAmigo;
	}
	public void setMensagemAmigo(String mensagemAmigo) {
		this.mensagemAmigo = mensagemAmigo;
	}
}