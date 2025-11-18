package br.com.jogoadivinhacao.modelo;

import br.com.jogoadivinhacao.servico.GeradorDicas;
import br.com.jogoadivinhacao.servico.GeradorNumero;

public class Jogo {
    private final Dificuldade dificuldade;
    private final int numeroSecreto;
    private final GeradorDicas geradorDicas;
    private int tentativasRestantes;
    private boolean acertou;
    private boolean dicaFornecida;

    public Jogo(Dificuldade dificuldade, GeradorNumero geradorNumero, GeradorDicas geradorDicas) {
        this.dificuldade = dificuldade;
        this.numeroSecreto = geradorNumero.gerar(dificuldade.getLimite());
        this.geradorDicas = geradorDicas;
        this.tentativasRestantes = dificuldade.getMaxTentativas();
        this.acertou = false;
        this.dicaFornecida = false;
    }

    public String verificarPalpite(int palpite) {
        tentativasRestantes--;

        if (palpite == numeroSecreto) {
            acertou = true;
            return "ACERTOU";
        } else if (palpite < numeroSecreto) {
            return "MENOR";
        } else {
            return "MAIOR";
        }
    }

    public String obterDica() {
        int tentativasUsadas = dificuldade.getMaxTentativas() - tentativasRestantes;
        int metadeTentativas = dificuldade.getMaxTentativas() / 2;

        if (tentativasUsadas == metadeTentativas && !acertou && !dicaFornecida) {
            dicaFornecida = true;
            return geradorDicas.gerarDica(numeroSecreto, dificuldade);
        }
        return null;
    }

    public boolean estaFinalizado() {
        return acertou || tentativasRestantes <= 0;
    }

    public Estatisticas gerarEstatisticas() {
        int tentativasUsadas = dificuldade.getMaxTentativas() - tentativasRestantes;
        return new Estatisticas(tentativasUsadas, dificuldade, acertou, numeroSecreto);
    }

    // Getters
    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }

    public boolean isAcertou() {
        return acertou;
    }

    public int getNumeroSecreto() {
        return numeroSecreto;
    }
}
