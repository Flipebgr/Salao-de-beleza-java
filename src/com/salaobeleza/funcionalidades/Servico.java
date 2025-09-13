package com.salaobeleza.funcionalidades;

import com.salaobeleza.enums.TipoServico;
import com.salaobeleza.interfaces.Agendavel;

public class Servico implements Agendavel {
    private String nome;
    private double preco;
    private TipoServico tipo;

    public static final double MAX_DESCONTO = 0.15;
    public static final double TAXA_SERVICO = 0.05;

    public Servico(String nome, double preco, TipoServico tipo) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }

    @Override
    public void agendar() {
        System.out.println("Agendando serviço: " + nome);
    }

    @Override
    public void cancelar() {
        System.out.println("Cancelando serviço: " + nome);
    }

    public double getPreco() { return preco; }
    public String getNome() { return nome; }
    public TipoServico getTipo() { return tipo; }

    @Override
    public String toString() {
        return nome + " - R$ " + preco + " - Tipo: " + tipo;
    }
}