package br.com.jogoadivinhacao.modelo;

public class Estatisticas {
    private final int tentativasUsadas;
    private final Dificuldade dificuldade;
    private final boolean venceu;
    private final int numeroSecreto;

    public Estatisticas(int tentativasUsadas, Dificuldade dificuldade, boolean venceu, int numeroSecreto) {
        this.tentativasUsadas = tentativasUsadas;
        this.dificuldade = dificuldade;
        this.venceu = venceu;
        this.numeroSecreto = numeroSecreto;
    }

    public void exibir() {
        System.out.println("\n===== ESTATÍSTICAS DA PARTIDA =====");
        System.out.println("Dificuldade: " + dificuldade.getNome());
        System.out.println("Número secreto: " + numeroSecreto);
        System.out.println("Tentativas usadas: " + tentativasUsadas + "/" + dificuldade.getMaxTentativas());
        System.out.println("Resultado: " + (venceu ? "VITÓRIA! 🎉" : "DERROTA"));
        System.out.println("===================================\n");
    }

    public int getTentativasUsadas() {
        return tentativasUsadas;
    }

    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    public boolean isVenceu() {
        return venceu;
    }

    public int getNumeroSecreto() {
        return numeroSecreto;
    }
}
