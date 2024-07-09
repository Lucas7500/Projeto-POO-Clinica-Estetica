package com.clinicaestetica.Models;

public abstract class Pessoa {
	private String nomeCompleto;
	private  Long  cpf;
	private  Long contato;
	private char genero;
	// dados em Long para poder fazer a conversão em string caso necessário
	
	
	
	@Override
	public String toString() {
		return String.format("Nome Completo: %s\nCPF: %s\nGênero: %c\nTelefone: %s\n",
				getNomeCompleto(), getCpf(), getGenero(), getContato());
	}


	public Pessoa(String nomeCompleto, Long cpf, Long contato, char genero) {
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.contato = contato;
		this.genero = genero;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public Long getCpf() {
		return cpf;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}


	public Long getContato() {
		return contato;
	}


	public void setContato(Long contato) {
		this.contato = contato;
	}


	public char getGenero() {
		return genero;
	}


	public void setGenero(char genero) {
		this.genero = genero;
	}
}
