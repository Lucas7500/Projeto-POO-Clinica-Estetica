package com.clinicaestetica.Models;

import java.time.LocalDateTime;

public class Sessao {
	private static int idAtual = 0;
	
	private int id;
	private LocalDateTime data; 
	private int clienteId;
	private int profissionalId;
	
	public Sessao(LocalDateTime data, int clienteId, int profissionalId) {
		this.id = ++idAtual;
		this.data = data; 
		this.clienteId = clienteId;
		this.profissionalId = profissionalId;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public int getClienteId() {
		return clienteId;
	}

	public int getProfissionalId() {
		return profissionalId;
	}

	public void setProfissionalId(int profissionalId) {
		this.profissionalId = profissionalId;
	}
}
