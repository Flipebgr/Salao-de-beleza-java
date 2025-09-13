package com.salaobeleza.funcionalidades;

import com.salaobeleza.usuarios.Cliente;
import com.salaobeleza.usuarios.funcionario;
import java.util.ArrayList;
import java.util.List;

public class Salao {
    private static Salao instancia;
    private List<Cliente> clientes = new ArrayList<>();
    private List<funcionario> funcionarios = new ArrayList<>();
    private List<Servico> servicos = new ArrayList<>();
    private List<Agendamento> agendamentos = new ArrayList<>();

    private Salao() {}

    public static Salao getInstancia() {
        if (instancia == null) {
            instancia = new Salao();
        }
        return instancia;
    }

    public void cadastrarCliente(Cliente c) { clientes.add(c); }
    public void cadastrarFuncionario(funcionario f) { funcionarios.add(f); }
    public void cadastrarServico(Servico s) { servicos.add(s); }

    public List<Cliente> getClientes() { return clientes; }
    public List<funcionario> getFuncionarios() { return funcionarios; }
    public List<Servico> getServicos() { return servicos; }

    public void listarAgendamentos() {
        if (agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento encontrado.");
            return;
        }

        System.out.println("=== AGENDAMENTOS ===");
        for (int i = 0; i < agendamentos.size(); i++) {
            System.out.println((i+1) + ". " + agendamentos.get(i));
        }
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("=== CLIENTES ===");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.println((i+1) + ". " + c.getDados() + " - Endereço: " + c.getEndereco());
        }
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("=== FUNCIONÁRIOS ===");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println((i+1) + ". " + funcionarios.get(i).getDados());
        }
    }

    public void listarServicos() {
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado.");
            return;
        }

        System.out.println("=== SERVIÇOS ===");
        for (int i = 0; i < servicos.size(); i++) {
            System.out.println((i+1) + ". " + servicos.get(i));
        }
    }

    public void adicionarAgendamento(Agendamento a) throws Exception {
        for (Agendamento existente : agendamentos) {
            if (existente.toString().equals(a.toString())) {
                throw new Exception("Conflito de agendamento!");
            }
        }
        agendamentos.add(a);
    }
}