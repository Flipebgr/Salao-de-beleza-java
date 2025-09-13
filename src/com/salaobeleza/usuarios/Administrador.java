package com.salaobeleza.usuarios;

public class Administrador extends funcionario {
    public Administrador(String nome, String telefone, String email, String cargo) {
        super(nome, telefone, email, cargo);
    }

    public void gerenciarSistema() {
        System.out.println("Administrador gerenciando o sistema...");
    }
}