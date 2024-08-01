package com.clinicaestetica.Models;

import java.util.ArrayList;
import java.util.List;

import com.clinicaestetica.Models.Interfaces.Financeiro;

public class Clinica
			implements Financeiro{
	private static int idAtual;
	private int id;
	private String endereco;
	private List<Profissional> profissionais;
	private double contabilidadeClinica;
	
	public void contabilidade(double valor) {
		contabilidadeClinica +=valor;
	}
	
	public void addProfissional(Profissional p) {
		
		profissionais.add(p);
	}
	
	public Clinica(String endereco) {
		profissionais = new ArrayList<>();
		this.id = ++idAtual;
		this.endereco = endereco;
		this.contabilidadeClinica = 0;
		
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
	
	public double getcontabilidadeClinica() {
		return contabilidadeClinica;
	}
}
