package com.clinicaestetica.Models;

public class Profissional extends Pessoa {
	private static int idAtual = 0;
	
	private int id;
	private boolean disponivel;

	public Profissional(String nomeCompleto, String cpf, String contato, char genero) {
		super(nomeCompleto, cpf, contato, genero);
		this.id = ++idAtual;
	}

	public int getId() {
		return id;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
}
