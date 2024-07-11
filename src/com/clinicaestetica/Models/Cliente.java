package com.clinicaestetica.Models;

import java.util.ArrayList;
import java.util.List;

import com.clinicaestetica.Models.Enums.Pagamento;

public class Cliente extends Pessoa {
	private static int idAtual = 0;
	
	private int id;
	private List<Pacote> pacotes;
	
	
	
	public void addPacote(Pacote p) {
		pacotes.add(p);
	}
	
	public void addSessaPacote(Sessao s) {
		Pacote pacote = pacotes.getLast();
		pacote.addSessao(s);
	}
	
	public Cliente(String nomeCompleto, Long cpf, Long contato, char genero) {
		super(nomeCompleto, cpf, contato, genero);
		this.pacotes = new ArrayList<>();
		this.id = ++idAtual;
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

	@Override
	public String toString() {
		
		return '\n' + getNomeCompleto() + " - CPF:"+getCpf() + " -  telefone: "+ getContato()+ " - Genero: "+ getGenero()
				+'\n' + pacotes;
	}
	
	
	
	
}
