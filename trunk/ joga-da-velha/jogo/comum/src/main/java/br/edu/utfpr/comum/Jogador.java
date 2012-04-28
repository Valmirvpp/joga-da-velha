package br.edu.utfpr.comum;

import java.io.Serializable;

public class Jogador implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private Long id;
	
	public Jogador() {
	}

	public Jogador(String nome, Long id) {
		super();
		this.nome = nome;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
