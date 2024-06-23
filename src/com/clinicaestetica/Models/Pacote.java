package com.clinicaestetica.Models;

import java.util.ArrayList;
import java.util.List;

import com.clinicaestetica.Models.Enums.TipoPacote;

public class Pacote {
	private static int idAtual = 0;
	
	private int id;
	private TipoPacote tipoPacote;
	private List<Profissional> profissionais;
	private List<Sessao> sessoes;
	private double valorPacote;
	private double valorUnitario;
	
	public Pacote(TipoPacote tipoPacote) {
		this.id = ++idAtual;
		
		if(tipoPacote.equals(TipoPacote.COMUM)) {
			this.sessoes = new ArrayList<>(4);
			valorUnitario = 180;
			setValorPacote(valorUnitario*4); 
		}
		else {
			if(tipoPacote.equals(TipoPacote.VIP)) {
				this.sessoes = new ArrayList<>(6);
				valorUnitario = 150;
				setValorPacote(valorUnitario*6); 
			}			
			else {
				if(tipoPacote.equals(TipoPacote.PREMIUM)) {
					this.sessoes = new ArrayList<>(10);
					valorUnitario = 130;
					setValorPacote(valorUnitario*10); 
				}
			}
		}
		
	}

	public int getId() {
		return id;
	}
	
	public TipoPacote getTipoPacote() {
		return tipoPacote;
	}

	public void setTipoPacote(TipoPacote tipoPacote) {
		this.tipoPacote = tipoPacote;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}
	
	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public double getValorPacote() {
		return valorPacote;
	}

	public void setValorPacote(double valorPacote) {
		this.valorPacote = valorPacote;
	}

	
}
