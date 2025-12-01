package br.com.jogoadivinhacao.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DificuldadeTest {
    @Test
    void testDificuldadeFacilPropriedades() {
        assertEquals(50, Dificuldade.FACIL.getLimite());
        assertEquals(12, Dificuldade.FACIL.getMaxTentativas());
        assertEquals("Fácil", Dificuldade.FACIL.getNome());
    }

    @Test
    void testDificuldadeMedioPropriedades() {
        assertEquals(500, Dificuldade.MEDIO.getLimite());
        assertEquals(10, Dificuldade.MEDIO.getMaxTentativas());
        assertEquals("Médio", Dificuldade.MEDIO.getNome());
    }

    @Test
    void testDificuldadeDificilPropriedades() {
        assertEquals(5000, Dificuldade.DIFICIL.getLimite());
        assertEquals(8, Dificuldade.DIFICIL.getMaxTentativas());
        assertEquals("Difícil", Dificuldade.DIFICIL.getNome());
    }

    @Test
    void testGetDescricao() {
        String descricao = Dificuldade.FACIL.getDescricao();
        assertTrue(descricao.contains("Fácil"));
        assertTrue(descricao.contains("50"));
        assertTrue(descricao.contains("12"));
    }

    @Test
    void testFromOpcaoComNumero() {
        assertEquals(Dificuldade.FACIL, Dificuldade.fromOpcao("1"));
        assertEquals(Dificuldade.MEDIO, Dificuldade.fromOpcao("2"));
        assertEquals(Dificuldade.DIFICIL, Dificuldade.fromOpcao("3"));
    }

    @Test
    void testFromOpcaoComTexto() {
        assertEquals(Dificuldade.FACIL, Dificuldade.fromOpcao("facil"));
        assertEquals(Dificuldade.MEDIO, Dificuldade.fromOpcao("médio"));
        assertEquals(Dificuldade.DIFICIL, Dificuldade.fromOpcao("difícil"));
    }

    @Test
    void testFromOpcaoComTextoMaiusculo() {
        assertEquals(Dificuldade.FACIL, Dificuldade.fromOpcao("FACIL"));
        assertEquals(Dificuldade.MEDIO, Dificuldade.fromOpcao("MEDIO"));
    }

    @Test
    void testFromOpcaoComEspacos() {
        assertEquals(Dificuldade.FACIL, Dificuldade.fromOpcao("  1  "));
        assertEquals(Dificuldade.MEDIO, Dificuldade.fromOpcao("  medio  "));
    }

    @Test
    void testFromOpcaoInvalida() {
        assertNull(Dificuldade.fromOpcao("4"));
        assertNull(Dificuldade.fromOpcao("invalido"));
        assertNull(Dificuldade.fromOpcao(""));
    }
}
