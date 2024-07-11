package com.clinicaestetica.Models;

import com.clinicaestetica.Models.Interfaces.Financeiro;

public class Profissional extends Pessoa
						implements Financeiro{
	private static int idAtual = 0;
	
	private int id;
	private boolean disponivel;
	private double contabAtendimentos;
	
	public void contabilidade(double valor) {
		this.contabAtendimentos += valor;
	}
	
	public Profissional(String nomeCompleto, Long cpf, Long contato, char genero) {
		super(nomeCompleto, cpf, contato, genero);
		this.id = ++idAtual;
		this.contabAtendimentos = 0;
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
	
	public double getContabAtendimentos() {
		return contabAtendimentos;
	}
	@Override
	public String toString() {
		 return   getNomeCompleto() + " - CPF:"+getCpf() + " -  telefone: "+ getContato()+ " - Genero: "+ getGenero();
	}
	
}
