package com.salaobeleza.funcionalidades;

import com.salaobeleza.usuarios.Cliente;
import com.salaobeleza.usuarios.funcionario;

public class Agendamento {
    private Cliente cliente;
    private funcionario funcionario;
    private Servico servico;
    private String dataHora;

    public Agendamento(Cliente cliente, funcionario funcionario, Servico servico, String dataHora) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.dataHora = dataHora;
    }

    public void confirmar() {
        System.out.println("Agendamento confirmado para " + cliente.getNome() + " com " + funcionario.getNome());
    }

    public void cancelar() {
        System.out.println("Agendamento cancelado!");
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() +
                ", Funcionário: " + funcionario.getNome() +
                ", Serviço: " + servico.getNome() +
                ", Data/Hora: " + dataHora;
    }
}