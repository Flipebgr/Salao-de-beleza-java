package com.salaobeleza;

import com.salaobeleza.enums.TipoServico;
import com.salaobeleza.funcionalidades.*;
import com.salaobeleza.usuarios.*;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Salao salao = Salao.getInstancia();

    // Patterns for validation
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-ZÀ-ÿ\\s]{2,}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{10,11}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    public static void main(String[] args) {
        // Adicionar alguns dados de exemplo
        inicializarDadosExemplo();

        // Exibir menu principal
        exibirMenuPrincipal();
    }

    private static void inicializarDadosExemplo() {
        Endereco e1 = new Endereco("Rua A", 123, "Belém");
        Cliente c1 = new Cliente("Arthur", "9999999999", "arthur@email.com", e1);
        funcionario f1 = new funcionario("Lua", "8888888888", "lua@email.com", "Cabelereira");
        Servico s1 = new Servico("Corte de cabelo", 50.0, TipoServico.CABELO);
        Servico s2 = new Servico("Manicure", 35.0, TipoServico.UNHA);

        salao.cadastrarCliente(c1);
        salao.cadastrarFuncionario(f1);
        salao.cadastrarServico(s1);
        salao.cadastrarServico(s2);
    }

    public static void exibirMenuPrincipal() {
        int opcao = -1;

        do {
            System.out.println("\n=== Sistema de Agendamento de Beleza ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Cadastrar Serviço");
            System.out.println("4. Realizar Agendamento");
            System.out.println("5. Listar Agendamentos");
            System.out.println("6. Listar Clientes");
            System.out.println("7. Listar Funcionários");
            System.out.println("8. Listar Serviços");
            System.out.println("0. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                String input = scanner.nextLine();
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido entre 0 e 8!");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    cadastrarServico();
                    break;
                case 4:
                    realizarAgendamento();
                    break;
                case 5:
                    salao.listarAgendamentos();
                    break;
                case 6:
                    salao.listarClientes();
                    break;
                case 7:
                    salao.listarFuncionarios();
                    break;
                case 8:
                    salao.listarServicos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Escolha entre 0 e 8.");
            }
        } while (opcao != 0);
    }

    // Validation methods
    private static boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    private static boolean isValidPhone(String phone) {
        // Remove any non-digit characters
        String cleanedPhone = phone.replaceAll("[^0-9]", "");
        return PHONE_PATTERN.matcher(cleanedPhone).matches();
    }

    private static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private static String getValidName(String fieldName) {
        String value;
        while (true) {
            System.out.print(fieldName + ": ");
            value = scanner.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println("Erro: " + fieldName + " não pode estar vazio!");
                continue;
            }

            if (!isValidName(value)) {
                System.out.println("Erro: " + fieldName + " deve conter apenas letras e espaços (mínimo 2 caracteres)!");
                continue;
            }

            break;
        }
        return value;
    }

    private static String getValidPhone() {
        String phone;
        while (true) {
            System.out.print("Telefone (apenas números, 10 ou 11 dígitos): ");
            phone = scanner.nextLine().trim();

            if (phone.isEmpty()) {
                System.out.println("Erro: Telefone não pode estar vazio!");
                continue;
            }

            if (!isValidPhone(phone)) {
                System.out.println("Erro: Telefone deve conter apenas números (10 ou 11 dígitos)!");
                continue;
            }

            // Clean the phone number (remove non-digit characters)
            phone = phone.replaceAll("[^0-9]", "");
            break;
        }
        return phone;
    }

    private static String getValidEmail() {
        String email;
        while (true) {
            System.out.print("Email: ");
            email = scanner.nextLine().trim();

            if (email.isEmpty()) {
                System.out.println("Erro: Email não pode estar vazio!");
                continue;
            }

            if (!isValidEmail(email)) {
                System.out.println("Erro: Formato de email inválido!");
                continue;
            }

            break;
        }
        return email;
    }

    private static int getValidNumber(String fieldName) {
        int number = 0;
        while (true) {
            try {
                System.out.print(fieldName + ": ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Erro: " + fieldName + " não pode estar vazio!");
                    continue;
                }

                number = Integer.parseInt(input);

                if (number <= 0) {
                    System.out.println("Erro: " + fieldName + " deve ser um número positivo!");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido para " + fieldName + "!");
            }
        }
        return number;
    }

    private static double getValidDouble(String fieldName) {
        double number = 0;
        while (true) {
            try {
                System.out.print(fieldName + ": ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Erro: " + fieldName + " não pode estar vazio!");
                    continue;
                }

                number = Double.parseDouble(input);

                if (number <= 0) {
                    System.out.println("Erro: " + fieldName + " deve ser um número positivo!");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido para " + fieldName + "!");
            }
        }
        return number;
    }

    private static void cadastrarCliente() {
        System.out.println("\n=== CADASTRAR CLIENTE ===");

        String nome = getValidName("Nome");
        String telefone = getValidPhone();
        String email = getValidEmail();

        System.out.print("Rua: ");
        String rua = scanner.nextLine().trim();
        while (rua.isEmpty()) {
            System.out.println("Erro: Rua não pode estar vazia!");
            System.out.print("Rua: ");
            rua = scanner.nextLine().trim();
        }

        int numero = getValidNumber("Número");

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine().trim();
        while (cidade.isEmpty()) {
            System.out.println("Erro: Cidade não pode estar vazia!");
            System.out.print("Cidade: ");
            cidade = scanner.nextLine().trim();
        }

        Endereco endereco = new Endereco(rua, numero, cidade);
        Cliente cliente = new Cliente(nome, telefone, email, endereco);

        salao.cadastrarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n=== CADASTRAR FUNCIONÁRIO ===");

        String nome = getValidName("Nome");
        String telefone = getValidPhone();
        String email = getValidEmail();

        System.out.print("Cargo: ");
        String cargo = scanner.nextLine().trim();
        while (cargo.isEmpty()) {
            System.out.println("Erro: Cargo não pode estar vazio!");
            System.out.print("Cargo: ");
            cargo = scanner.nextLine().trim();
        }

        funcionario funcionario = new funcionario(nome, telefone, email, cargo);
        salao.cadastrarFuncionario(funcionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private static void cadastrarServico() {
        System.out.println("\n=== CADASTRAR SERVIÇO ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        while (nome.isEmpty()) {
            System.out.println("Erro: Nome não pode estar vazio!");
            System.out.print("Nome: ");
            nome = scanner.nextLine().trim();
        }

        double preco = getValidDouble("Preço");

        System.out.println("Tipos de serviço disponíveis:");
        for (TipoServico tipo : TipoServico.values()) {
            System.out.println("- " + tipo);
        }

        TipoServico tipoServico = null;
        while (tipoServico == null) {
            System.out.print("Tipo de serviço: ");
            String tipoStr = scanner.nextLine().toUpperCase();

            try {
                tipoServico = TipoServico.valueOf(tipoStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de serviço inválido! Escolha entre: " + Arrays.toString(TipoServico.values()));
            }
        }

        Servico servico = new Servico(nome, preco, tipoServico);
        salao.cadastrarServico(servico);

        System.out.println("Serviço cadastrado com sucesso!");
    }

    private static void realizarAgendamento() {
        System.out.println("\n=== REALIZAR AGENDAMENTO ===");

        // Listar clientes
        List<Cliente> clientes = salao.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente primeiro.");
            return;
        }

        System.out.println("Clientes disponíveis:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i+1) + ". " + clientes.get(i).getNome());
        }

        int clienteIndex = -1;
        while (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            try {
                System.out.print("Escolha o cliente (número): ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Erro: Digite um número!");
                    continue;
                }

                clienteIndex = Integer.parseInt(input) - 1;

                if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
                    System.out.println("Número de cliente inválido! Escolha entre 1 e " + clientes.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!");
            }
        }

        // Listar funcionários
        List<funcionario> funcionarios = salao.getFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado. Cadastre um funcionário primeiro.");
            return;
        }

        System.out.println("Funcionários disponíveis:");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.println((i+1) + ". " + funcionarios.get(i).getNome());
        }

        int funcionarioIndex = -1;
        while (funcionarioIndex < 0 || funcionarioIndex >= funcionarios.size()) {
            try {
                System.out.print("Escolha o funcionário (número): ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Erro: Digite um número!");
                    continue;
                }

                funcionarioIndex = Integer.parseInt(input) - 1;

                if (funcionarioIndex < 0 || funcionarioIndex >= funcionarios.size()) {
                    System.out.println("Número de funcionário inválido! Escolha entre 1 e " + funcionarios.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!");
            }
        }

        // Listar serviços
        List<Servico> servicos = salao.getServicos();
        if (servicos.isEmpty()) {
            System.out.println("Nenhum serviço cadastrado. Cadastre um serviço primeiro.");
            return;
        }

        System.out.println("Serviços disponíveis:");
        for (int i = 0; i < servicos.size(); i++) {
            Servico s = servicos.get(i);
            System.out.println((i+1) + ". " + s.getNome() + " (R$ " + s.getPreco() + ")");
        }

        int servicoIndex = -1;
        while (servicoIndex < 0 || servicoIndex >= servicos.size()) {
            try {
                System.out.print("Escolha o serviço (número): ");
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Erro: Digite um número!");
                    continue;
                }

                servicoIndex = Integer.parseInt(input) - 1;

                if (servicoIndex < 0 || servicoIndex >= servicos.size()) {
                    System.out.println("Número de serviço inválido! Escolha entre 1 e " + servicos.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!");
            }
        }

        System.out.print("Data e Hora (ex: 12/09/2025 15:00): ");
        String dataHora = scanner.nextLine().trim();
        while (dataHora.isEmpty()) {
            System.out.println("Erro: Data e hora não podem estar vazios!");
            System.out.print("Data e Hora (ex: 12/09/2025 15:00): ");
            dataHora = scanner.nextLine().trim();
        }

        try {
            Cliente cliente = clientes.get(clienteIndex);
            funcionario funcionario = funcionarios.get(funcionarioIndex);
            Servico servico = servicos.get(servicoIndex);

            Agendamento agendamento = new Agendamento(cliente, funcionario, servico, dataHora);
            salao.adicionarAgendamento(agendamento);
            agendamento.confirmar();

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice inválido! Tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}