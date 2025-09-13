package com.salaobeleza.usuarios;

import com.salaobeleza.funcionalidades.Servico;
import java.util.ArrayList;
import java.util.List;

public class funcionario extends Pessoa {
    private String cargo;
    private List<Servico> servicosOferecidos = new ArrayList<>();

    public funcionario(String nome, String telefone, String email, String cargo) {
        super(nome, telefone, email);
        this.cargo = cargo;
    }

    @Override
    public String getDados() {
        return "Funcionario: " + nome + " - Cargo: " + cargo + " - Tel: " + telefone + " - Email: " + email;
    }

    @Override
    public String getTipo() {
        return "Funcionario";
    }

    public String getCargo() { return cargo; }
}