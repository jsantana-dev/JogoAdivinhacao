package br.com.jogoadivinhacao.modelo;

import br.com.jogoadivinhacao.servico.GeradorDicas;
import br.com.jogoadivinhacao.servico.GeradorNumero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JogoTest {
    private GeradorNumero geradorNumero;
    private GeradorDicas geradorDicas;

    @BeforeEach
    void setUp() {
        geradorNumero = new GeradorNumero();
        geradorDicas = new GeradorDicas();
    }

    @Test
    void testCriarJogoFacil() {
        Jogo jogo = new Jogo(Dificuldade.FACIL, geradorNumero, geradorDicas);

        assertEquals(Dificuldade.FACIL, jogo.getDificuldade());
        assertEquals(12, jogo.getTentativasRestantes());
        assertFalse(jogo.isAcertou());
        assertFalse(jogo.estaFinalizado());
    }

    @Test
    void testCriarJogoMedio() {
        Jogo jogo = new Jogo(Dificuldade.MEDIO, geradorNumero, geradorDicas);

        assertEquals(Dificuldade.MEDIO, jogo.getDificuldade());
        assertEquals(10, jogo.getTentativasRestantes());
    }

    @Test
    void testCriarJogoDificil() {
        Jogo jogo = new Jogo(Dificuldade.DIFICIL, geradorNumero, geradorDicas);

        assertEquals(Dificuldade.DIFICIL, jogo.getDificuldade());
        assertEquals(8, jogo.getTentativasRestantes());
    }

    @Test
    void testVerificarPalpiteCorreto() {
        Jogo jogo = new Jogo(Dificuldade.FACIL, geradorNumero, geradorDicas);
        int numeroSecreto = jogo.getNumeroSecreto();

        String resultado = jogo.verificarPalpite(numeroSecreto);

        assertEquals("ACERTOU", resultado);
        assertTrue(jogo.isAcertou());
        assertTrue(jogo.estaFinalizado());
    }

    @Test
    void testVerificarPalpiteMenor() {
        Jogo jogo = new Jogo(Dificuldade.FACIL, geradorNumero, geradorDicas);
        int numeroSecreto = jogo.getNumeroSecreto();

        String resultado = jogo.verificarPalpite(numeroSecreto - 10);

        assertEquals("MENOR", resultado);
        assertFalse(jogo.isAcertou());
        assertEquals(11, jogo.getTentativasRestantes());
    }

    @Test
    void testVerificarPalpiteMaior() {
        Jogo jogo = new Jogo(Dificuldade.FACIL, geradorNumero, geradorDicas);
        int numeroSecreto = jogo.getNumeroSecreto();

        String resultado = jogo.verificarPalpite(numeroSecreto + 10);

        assertEquals("MAIOR", resultado);
        assertFalse(jogo.isAcertou());
    }

    @Test
    void testTentativasDecrementam() {
        Jogo jogo = new Jogo(Dificuldade.FACIL, geradorNumero, geradorDicas);
        int tentativasIniciais = jogo.getTentativasRestantes();

        jogo.verificarPalpite(1);

        assertEquals(tentativasIniciais - 1, jogo.getTentativasRestantes());
    }

    @Test
    void testJogoFinalizaAposTodasTentativas() {
        Jogo jogo = new Jogo(Dificuldade.FACIL, geradorNumero, geradorDicas);

        // Erra todas as tentativas
        for (int i = 0; i < 12; i++) {
            jogo.verificarPalpite(-1); // Palpite impossível
        }

        assertTrue(jogo.estaFinalizado());
        assertFalse(jogo.isAcertou());
        assertEquals(0, jogo.getTentativasRestantes());
    }

    @Test
    void testObterDicaNaMetadeDasTentativas() {
        Jogo jogo = new Jogo(Dificuldade.FACIL, geradorNumero, geradorDicas);

        // Faz 5 tentativas (menos que a metade de 12)
        for (int i = 0; i < 5; i++) {
            jogo.verificarPalpite(-1);
            String dica = jogo.obterDica();
            if (i == 5) {
                assertNull(dica); // Ainda não chegou na metade
            }
        }

        // Na 6ª tentativa (metade de 12), deve fornecer dica
        jogo.verificarPalpite(-1);
        String dica = jogo.obterDica();
        assertNotNull(dica);
    }

    @Test
    void testDicaSoFornecidaUmaVez() {
        Jogo jogo = new Jogo(Dificuldade.MEDIO, geradorNumero, geradorDicas);

        // Faz 5 tentativas (metade de 10)
        for (int i = 0; i < 5; i++) {
            jogo.verificarPalpite(-1);
        }

        String primeiraDica = jogo.obterDica();
        assertNotNull(primeiraDica);

        // Próximas chamadas não devem retornar dica
        String segundaDica = jogo.obterDica();
        assertNull(segundaDica);
    }

    @Test
    void testGerarEstatisticas() {
        Jogo jogo = new Jogo(Dificuldade.FACIL, geradorNumero, geradorDicas);

        jogo.verificarPalpite(1);
        jogo.verificarPalpite(2);
        jogo.verificarPalpite(jogo.getNumeroSecreto());

        Estatisticas stats = jogo.gerarEstatisticas();

        assertNotNull(stats);
        assertEquals(3, stats.getTentativasUsadas());
        assertTrue(stats.isVenceu());
        assertEquals(Dificuldade.FACIL, stats.getDificuldade());
    }

    @Test
    void testEstatisticasComDerrota() {
        Jogo jogo = new Jogo(Dificuldade.FACIL, geradorNumero, geradorDicas);

        // Erra todas as tentativas
        for (int i = 0; i < 12; i++) {
            jogo.verificarPalpite(-1);
        }

        Estatisticas stats = jogo.gerarEstatisticas();

        assertEquals(12, stats.getTentativasUsadas());
        assertFalse(stats.isVenceu());
    }
}
