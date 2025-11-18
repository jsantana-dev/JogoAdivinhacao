package br.com.jogoadivinhacao.ui;

import br.com.jogoadivinhacao.modelo.Dificuldade;
import br.com.jogoadivinhacao.modelo.Jogo;
import br.com.jogoadivinhacao.util.ValidadorEntrada;

public class InterfaceConsole {
    private final ValidadorEntrada validador;

    public InterfaceConsole(ValidadorEntrada validador) {
        this.validador = validador;
    }

    public void exibirBoasVindas() {
        System.out.println("\n╔═══════════════════════════════════╗");
        System.out.println("║ BEM-VINDO AO JOGO DE ADIVINHAÇÃO! ║");
        System.out.println("╚═══════════════════════════════════╝\n");
    }

    public Dificuldade solicitarDificuldade() {
        System.out.println("Escolha o nível de dificuldade:");
        System.out.println("1. " + Dificuldade.FACIL.getDescricao());
        System.out.println("2. " + Dificuldade.MEDIO.getDescricao());
        System.out.println("3. " + Dificuldade.DIFICIL.getDescricao());

        Dificuldade dificuldade = null;
        while (dificuldade == null) {
            String opcao = validador.lerOpcao("\nDigite sua escolha: ");
            dificuldade = Dificuldade.fromOpcao(opcao);

            if (dificuldade == null) {
                System.out.println("Opção inválida. Por favor, escolha 1, 2 ou 3.");
            }
        }

        System.out.println("\n🎯 Dificuldade selecionada: " + dificuldade.getNome());
        System.out.println("Adivinhe o número entre 1 e " + dificuldade.getLimite());

        return dificuldade;
    }

    public int solicitarPalpite(Jogo jogo) {
        int tentativasUsadas = jogo.getDificuldade().getMaxTentativas() - jogo.getTentativasRestantes();
        System.out.println("─────────────────────────────────" + "\n");
        System.out.println("Tentativa " + (tentativasUsadas + 1) + " de " + jogo.getDificuldade().getMaxTentativas());
        return validador.lerInteiro("Seu palpite: ");
    }

    public void exibirResultadoPalpite(String resultado) {
        switch (resultado) {
            case "ACERTOU":
                System.out.println("🎉 PARABÉNS! Você acertou! 🎉");
                break;
            case "MENOR":
                System.out.println("⬆️  Muito baixo! Tente um número maior.");
                break;
            case "MAIOR":
                System.out.println("⬇️  Muito alto! Tente um número menor.");
                break;
        }
    }

    public void exibirDica(String dica) {
        if (dica != null) {
            System.out.println("\n💡 " + dica);
        }
    }
    public void exibirDerrota(int numeroSecreto) {
        System.out.println("\n😔 Que pena! Você não conseguiu adivinhar.");
        System.out.println("O número correto era: " + numeroSecreto);
    }

    public boolean perguntarJogarNovamente() {
        return validador.lerSimNao("\nDeseja jogar novamente? (sim/não): ");
    }

    public void exibirDespedida() {
        System.out.println("\n╔═══════════════════════════════════╗");
        System.out.println("║ OBRIGADO POR JOGAR! ATÉ A PRÓXIMA!║");
        System.out.println("╚═══════════════════════════════════╝\n");
    }
}
