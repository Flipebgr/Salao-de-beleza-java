package com.salaobeleza.usuarios;

public abstract class Pessoa {
    protected String nome;
    protected String telefone;
    protected String email;

    public Pessoa(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public abstract String getDados();
    public abstract String getTipo();
}