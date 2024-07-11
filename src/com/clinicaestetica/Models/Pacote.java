package com.clinicaestetica.Models;

import java.util.ArrayList;
import java.util.List;

import com.clinicaestetica.Models.Enums.Pagamento;
import com.clinicaestetica.Models.Enums.TipoPacote;

public class Pacote {
	private static int idAtual = 0;
	
	private int id;
	private TipoPacote tipoPacote;
	private List<Sessao> sessoes;
	private double valorUnitario;
	private int qntd;
	
	
	public void sessaoSemCobranca() {
		if(TipoPacote.UNICO == tipoPacote) {
			valorUnitario = 0.0;
		}	
	}
	
	public void addSessao(Sessao s) {
		if(!pacoteDisponivel()) {
			sessoes.add(s);
			if(s.getPagamento().equals(Pagamento.SEM_COBRANCA)) {
				sessaoSemCobranca();
				if(valorUnitario != 0) {
					s.alterarPagamento(Pagamento.PENDENTE);
				}
			}
		}
		s.setValor(valorUnitario);
		s.valorParaProfissional();
	}
	
	//Used in addSessao
	public boolean pacoteDisponivel() {
		boolean listaCheia = (sessoes.size() == qntd);
		return listaCheia;
	}
	
	public double valorPacote() {
		switch (tipoPacote){ 
			case COMUM:
				return 4*valorUnitario; 
			case VIP: 
				return 6*valorUnitario; 
			case PREMIUM:
				return 10*valorUnitario; 
			case UNICO: 
				return valorUnitario; 
			default: 
				return 0.0;
		}
	}
	
	public Pacote(TipoPacote tipoPacote) {
		this.id = ++idAtual;
		
		if(tipoPacote.equals(TipoPacote.COMUM)) {
			this.sessoes = new ArrayList<>(4);
			this.qntd = 4;
			valorUnitario = 180;
			this.tipoPacote = TipoPacote.COMUM;
		}
		else {
			if(tipoPacote.equals(TipoPacote.VIP)) {
				this.sessoes = new ArrayList<>(6);
				this.qntd = 6;
				valorUnitario = 150;
				this.tipoPacote = TipoPacote.VIP;
			}			
			else {
				if(tipoPacote.equals(TipoPacote.PREMIUM)) {
					this.sessoes = new ArrayList<>(10);
					this.qntd = 10;
					valorUnitario = 130;
					this.tipoPacote = TipoPacote.PREMIUM;
				}
				else {
					if(tipoPacote.equals(TipoPacote.UNICO)) {
						this.sessoes = new ArrayList<Sessao>(1);
						this.qntd = 1;
						valorUnitario = 200;
						this.tipoPacote = TipoPacote.UNICO;
					}
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
	
	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}

	public List<Sessao> getSessoes() {
		return sessoes;
	}
	
	public double getValorUnitario() {
		return valorUnitario;
	}

	@Override
	public String toString() {
		return "idPacote: " + id + "  -  tipoPacote: " + tipoPacote 
				+ "\n Sessoes: \n" + sessoes ;
	}

	
}
