package com.clinicaestetica.Models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private static int idAtual = 0;
    
    private int id;
    private List<Pacote> pacotes;
    private double contabSessoes;
    
    public Cliente(String nomeCompleto, String cpf, String contato, char genero) {
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

    public void addPacote(Pacote p) {
        pacotes.add(p);
    }
    
    public void addSessaoPacote(Sessao s) {
        Pacote pacote = pacotes.get(pacotes.size() - 1);
        pacote.addSessao(s);
        contabilidade(s.getValor());
    }
    
    public void contabilidade(double valor) {
        this.contabSessoes += valor;
    }

    public double getContabSessoes() {
        return contabSessoes;
    }

    @Override
    public String toString() {
        return '\n' + getNomeCompleto() + " - CPF:"+getCpf() + " -  telefone: "+ getContato()+ " - Genero: "+ getGenero()
                +'\n' + pacotes;
    }
}
