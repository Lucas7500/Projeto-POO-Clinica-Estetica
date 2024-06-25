package com.clinicaestetica.Models;

import java.time.LocalDateTime;

import com.clinicaestetica.Models.Enums.Pagamento;
import com.clinicaestetica.Models.Enums.Status;

public class Atendimento {
	private static int idAtual = 0;
	private int teste;
	private int id;
	private LocalDateTime data; 
	private int clienteId;
	private String clinica;
	private double valor;
	private String observacao;
	private Pagamento pagamentoAtend;
	private Status statusAtend;
	
	public Atendimento(int id, LocalDateTime data, int clienteId, String clinica,
			double valor, Pagamento pagamentoAtend, Status statusAtend) {
		this.id = ++idAtual;
		this.data = data;
		this.clienteId = clienteId;
		this.clinica = clinica;
		this.valor = valor;
		this.pagamentoAtend = Pagamento.PENDENTE;
		this.statusAtend = Status.EM_ATENDIMENTO;
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

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getClinica() {
		return clinica;
	}

	public void setClinica(String clinica) {
		this.clinica = clinica;
	}

	public Status getStatusAtend() {
		return statusAtend;
	}

	public void setStatusAtend(Status statusAtend) {
		this.statusAtend = statusAtend;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Pagamento getPagamentoAtend() {
		return pagamentoAtend;
	}

	public void setPagamentoAtend(Pagamento pagamentoAtend) {
		this.pagamentoAtend = pagamentoAtend;
	}
}
