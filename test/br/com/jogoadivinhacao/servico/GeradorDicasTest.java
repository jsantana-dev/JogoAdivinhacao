package br.com.jogoadivinhacao.servico;

import br.com.jogoadivinhacao.modelo.Dificuldade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeradorDicasTest {
    private GeradorDicas geradorDicas;

    @BeforeEach
    void setUp() {
        geradorDicas = new GeradorDicas();
    }

    // Testes para nível FÁCIL
    @Test
    void testDicaFacilNumeroPar() {
        String dica = geradorDicas.gerarDica(10, Dificuldade.FACIL);
        assertTrue(dica.contains("par"));
    }

    @Test
    void testDicaFacilNumeroImpar() {
        String dica = geradorDicas.gerarDica(15, Dificuldade.FACIL);
        assertTrue(dica.contains("ímpar"));
    }

    // Testes para nível MÉDIO
    @Test
    void testDicaMedioNumeroPrimo() {
        String dica = geradorDicas.gerarDica(17, Dificuldade.MEDIO);
        assertTrue(dica.contains("primo"));
    }

    @Test
    void testDicaMedioNumeroDivisivel() {
        String dica = geradorDicas.gerarDica(20, Dificuldade.MEDIO);
        assertTrue(dica.contains("divisível"));
    }

    @Test
    void testDicaMedioMenorDivisor() {
        String dica = geradorDicas.gerarDica(15, Dificuldade.MEDIO);
        // 15 é divisível por 3 (menor divisor)
        assertTrue(dica.contains("3"));
    }

    // Testes para nível DIFÍCIL
    @Test
    void testDicaDificilQuadradoPerfeito() {
        String dica = geradorDicas.gerarDica(25, Dificuldade.DIFICIL);
        assertTrue(dica.contains("quadrado perfeito"));
    }

    @Test
    void testDicaDificilNumeroPrimo() {
        String dica = geradorDicas.gerarDica(37, Dificuldade.DIFICIL);
        assertTrue(dica.contains("primo"));
    }

    @Test
    void testDicaDificilSomaDigitos() {
        String dica = geradorDicas.gerarDica(123, Dificuldade.DIFICIL);
        // Soma dos dígitos de 123 = 1 + 2 + 3 = 6
        assertTrue(dica.contains("soma") && dica.contains("6"));
    }

    @Test
    void testQuadradosPerfeitosComuns() {
        assertTrue(geradorDicas.gerarDica(1, Dificuldade.DIFICIL).contains("quadrado perfeito"));
        assertTrue(geradorDicas.gerarDica(4, Dificuldade.DIFICIL).contains("quadrado perfeito"));
        assertTrue(geradorDicas.gerarDica(9, Dificuldade.DIFICIL).contains("quadrado perfeito"));
        assertTrue(geradorDicas.gerarDica(16, Dificuldade.DIFICIL).contains("quadrado perfeito"));
        assertTrue(geradorDicas.gerarDica(100, Dificuldade.DIFICIL).contains("quadrado perfeito"));
    }

    @Test
    void testNumerosPrimosComuns() {
        assertTrue(geradorDicas.gerarDica(2, Dificuldade.MEDIO).contains("primo"));
        assertTrue(geradorDicas.gerarDica(3, Dificuldade.MEDIO).contains("primo"));
        assertTrue(geradorDicas.gerarDica(5, Dificuldade.MEDIO).contains("primo"));
        assertTrue(geradorDicas.gerarDica(7, Dificuldade.MEDIO).contains("primo"));
        assertTrue(geradorDicas.gerarDica(11, Dificuldade.MEDIO).contains("primo"));
    }

    @Test
    void testDicaNuncaNula() {
        assertNotNull(geradorDicas.gerarDica(42, Dificuldade.FACIL));
        assertNotNull(geradorDicas.gerarDica(42, Dificuldade.MEDIO));
        assertNotNull(geradorDicas.gerarDica(42, Dificuldade.DIFICIL));
    }
}
