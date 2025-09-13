package com.salaobeleza.usuarios;


import com.salaobeleza.funcionalidades.Agendamento;
import com.salaobeleza.funcionalidades.Endereco;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private List<Agendamento> historicoAgendamentos = new ArrayList<>();
    private Endereco endereco;

    public Cliente(String nome, String telefone, String email, Endereco endereco) {
        super(nome, telefone, email);
        this.endereco = endereco;
    }

    @Override
    public String getDados() {
        return "Cliente: " + nome + " - Tel: " + telefone + " - Email: " + email;
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }

    public Endereco getEndereco() { return endereco; }
}