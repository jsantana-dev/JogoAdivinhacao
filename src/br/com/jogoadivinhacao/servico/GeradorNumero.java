package br.com.jogoadivinhacao.servico;

import java.util.Random;

public class GeradorNumero {
    private final Random random;

    public GeradorNumero() {
        this.random = new Random();
    }

    public int gerar(int limite) {
        return random.nextInt(limite) + 1;
    }
}
