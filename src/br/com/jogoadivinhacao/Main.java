package br.com.jogoadivinhacao;

import br.com.jogoadivinhacao.modelo.Dificuldade;
import br.com.jogoadivinhacao.modelo.Estatisticas;
import br.com.jogoadivinhacao.modelo.Jogo;
import br.com.jogoadivinhacao.servico.GeradorDicas;
import br.com.jogoadivinhacao.servico.GeradorNumero;
import br.com.jogoadivinhacao.ui.InterfaceConsole;
import br.com.jogoadivinhacao.util.ValidadorEntrada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidadorEntrada validador = new ValidadorEntrada(scanner);
        InterfaceConsole ui = new InterfaceConsole(validador);
        GeradorNumero geradorNumero = new GeradorNumero();
        GeradorDicas geradorDicas = new GeradorDicas();

        ui.exibirBoasVindas();

        boolean jogarNovamente = true;

        while (jogarNovamente) {
            // Solicitar dificuldade
            Dificuldade dificuldade = ui.solicitarDificuldade();

            // Criar novo jogo
            Jogo jogo = new Jogo(dificuldade, geradorNumero, geradorDicas);

            // Loop principal do jogo
            while (!jogo.estaFinalizado()) {
                int palpite = ui.solicitarPalpite(jogo);
                String resultado = jogo.verificarPalpite(palpite);
                ui.exibirResultadoPalpite(resultado);

                // Verificar se deve fornecer dica
                String dica = jogo.obterDica();
                ui.exibirDica(dica);
            }

            // Exibir resultado final
            if (!jogo.isAcertou()) {
                ui.exibirDerrota(jogo.getNumeroSecreto());
            }

            // Exibir estatísticas
            Estatisticas stats = jogo.gerarEstatisticas();
            stats.exibir();

            // Perguntar se quer jogar novamente
            jogarNovamente = ui.perguntarJogarNovamente();
        }

        ui.exibirDespedida();
        scanner.close();
    }
}
