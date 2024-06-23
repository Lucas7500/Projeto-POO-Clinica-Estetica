package com.clinicaestetica.Models;

public abstract class Pessoa {
	private String nomeCompleto;
	private String cpf;
	private String contato;
	private char genero;
	
	public Pessoa(String nomeCompleto, String cpf, String contato, char genero) {
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.contato = contato;
		this.genero = genero;
	}

	public Pessoa() {
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}
	
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return contato;
	}
	
	public void setTelefone(String telefone) {
		this.contato = telefone;
	}
	
	public char getGenero() {
		return genero;
	}
	
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return String.format("Nome Completo: %s\nCPF: %s\nGênero: %c\nTelefone: %s\n",
				getNomeCompleto(), getCpf(), getGenero(), getTelefone());
	}
}
