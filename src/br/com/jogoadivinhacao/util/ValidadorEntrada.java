package br.com.jogoadivinhacao.util;

import java.util.Scanner;

public class ValidadorEntrada {
    private final Scanner scanner;

    public ValidadorEntrada(Scanner scanner) {
        this.scanner = scanner;
    }

    public int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
                return valor;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar buffer
            }
        }
    }

    public String lerOpcao(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    public boolean lerSimNao(String mensagem) {
        System.out.print(mensagem);
        String resposta = scanner.nextLine().trim().toLowerCase();
        return resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s");
    }
}
