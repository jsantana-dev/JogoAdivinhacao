package br.com.jogoadivinhacao.modelo;

public enum Dificuldade {
    FACIL(50, 12, "Fácil"),
    MEDIO(500, 10, "Médio"),
    DIFICIL(5000, 8, "Difícil");

    private final int limite;
    private final int maxTentativas;
    private final String nome;

    Dificuldade(int limite, int maxTentativas, String nome) {
        this.limite = limite;
        this.maxTentativas = maxTentativas;
        this.nome = nome;
    }

    public int getLimite() {
        return limite;
    }

    public int getMaxTentativas() {
        return maxTentativas;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return nome + " (1 a " + limite + " - " + maxTentativas + " tentativas)";
    }

    public static Dificuldade fromOpcao(String opcao) {
        switch (opcao.trim().toLowerCase()) {
            case "1":
            case "facil":
            case "fácil":
                return FACIL;
            case "2":
            case "medio":
            case "médio":
                return MEDIO;
            case "3":
            case "dificil":
            case "difícil":
                return DIFICIL;
            default:
                return null;
        }
    }
}