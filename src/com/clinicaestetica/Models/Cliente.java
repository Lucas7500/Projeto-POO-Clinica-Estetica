package com.clinicaestetica.Models;

public class Cliente extends Pessoa {
	private static int idAtual = 0;
	
	private int id;
	private Pacote pacote;
	
	public Cliente() {}
	
	public Cliente(String nomeCompleto, String cpf, String contato, char genero) {
		super(nomeCompleto, cpf, contato, genero);
		this.id = ++idAtual;
	}

	public int getId() {
		return id;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}
	
	public boolean possuiPacote() {
		return pacote != null;
	}
}
