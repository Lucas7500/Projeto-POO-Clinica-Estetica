package com.clinicaestetica.Models;


import java.time.LocalDateTime;

import com.clinicaestetica.Models.Enums.Pagamento;
import com.clinicaestetica.Models.Enums.Status;


public class Sessao {
	private static int idAtual = 0;
	
	private int id;
	private LocalDateTime data; 
	private String observacao;
	private Pagamento pagamento;
	private Status status;
	private Profissional profissional;
	private Cliente cliente;
	private Clinica clinica;
	
	
	
	public void alterarStatus(Status sts,LocalDateTime dat ) {
		switch (sts){ 
			case REMARCADO:
				data = dat;
				// n precisa aalterar o status, pois estará agendado dnv
				break;
			case CONCLUIDO: 
				status = sts;
				break;
			case CANCELADO:
				status = sts;
				data = null;
				break;
			default: 
				break;
		}
	}
	
	public void addObservacao(String obs) {
		this.observacao = obs; 
	}
	

	public Sessao( LocalDateTime data, Pagamento pagamento,Profissional profissional, Cliente cliente, Clinica clinica) {
		this.id = ++idAtual;
		this.data = data;
		this.pagamento = pagamento;
		this.status = Status.AGENDADO;
		this.profissional = profissional;
		this.cliente = cliente;
		this.clinica = clinica;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public String getObservacao() {
		return observacao;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Status getStatus() {
		return status;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	
}
