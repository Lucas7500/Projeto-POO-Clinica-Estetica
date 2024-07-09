package com.clinicaestetica.Models;

import java.util.List;

public class Clinica {
	private static int idAtual;
	private int id;
	private String endereco;
	private List<Profissional> profissionais;
	
	
	
	public void addProfissional(Profissional p) {
		profissionais.add(p);
	}
	
	public Clinica(int id, String endereco, List<Profissional> profissionais) {
		this.id = ++idAtual;
		this.endereco = endereco;
		
	}
	
	public int getId() {
		return id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public List<Profissional> getProfissionais() {
		return profissionais;
	}
	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}
	
}
