package com.clinicaestetica.Models;

import java.util.ArrayList;
import java.util.List;

import com.clinicaestetica.Models.Interfaces.Financeiro;



public class Cliente extends Pessoa
					implements Financeiro{
	private static int idAtual = 0;
	
	private int id;
	private List<Pacote> pacotes;
	private double contabSessoes;
	
	public void addPacote(Pacote p) {
		pacotes.add(p);
	}
	
	// aqui(15:30)
	public void addSessaPacote(Sessao s) {
		
		Pacote pacote = pacotes.get(pacotes.size() - 1);
		pacote.addSessao(s);
		contabilidade(s.getValor());
	}
	
	@Override
	public void contabilidade(double valor) {
		this.contabSessoes += valor;
	}
	
	public Cliente(String nomeCompleto, Long cpf, Long contato, char genero) {
		super(nomeCompleto, cpf, contato, genero);
		this.pacotes = new ArrayList<>();
		this.id = ++idAtual;
		contabSessoes = 0;
	}

	public int getId() {
		return id;
	}

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double  getContabSessoes() {
		return contabSessoes;
	}
	@Override
	public String toString() {
		
		return '\n' + getNomeCompleto() + " - CPF:"+getCpf() + " -  telefone: "+ getContato()+ " - Genero: "+ getGenero()
				+'\n' + pacotes;
	}
	
	
	
	
}
