package br.com.jogoadivinhacao.servico;

import br.com.jogoadivinhacao.modelo.Dificuldade;

public class GeradorDicas {

    public String gerarDica(int numero, Dificuldade dificuldade) {
        switch (dificuldade) {
            case FACIL:
                return gerarDicaFacil(numero);
            case MEDIO:
                return gerarDicaMedio(numero);
            case DIFICIL:
                return gerarDicaDificil(numero);
            default:
                return "Sem dica disponível.";
        }
    }

    private String gerarDicaFacil(int numero) {
        return "Dica: O número é " + (numero % 2 == 0 ? "par." : "ímpar.");
    }

    private String gerarDicaMedio(int numero) {
        int divisor = encontrarMenorDivisor(numero);
        if (divisor != -1) {
            return "Dica: O número é divisível por " + divisor + ".";
        } else {
            return "Dica: O número é primo.";
        }
    }

    private String gerarDicaDificil(int numero) {
        if (isQuadradoPerfeito(numero)) {
            return "Dica: O número é um quadrado perfeito.";
        } else if (isPrimo(numero)) {
            return "Dica: O número é primo.";
        } else {
            return "Dica: A soma dos dígitos do número é " + somaDosDigitos(numero) + ".";
        }
    }

    private boolean isQuadradoPerfeito(int numero) {
        int raiz = (int) Math.sqrt(numero);
        return raiz * raiz == numero;
    }

    private boolean isPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int encontrarMenorDivisor(int numero) {
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return i;
            }
        }
        return -1;
    }

    private int somaDosDigitos(int numero) {
        int soma = 0;
        while (numero > 0) {
            soma += numero % 10;
            numero /= 10;
        }
        return soma;
    }
}
