package br.com.jogoadivinhacao.servico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeradorNumeroTest {
    private GeradorNumero geradorNumero;

    @BeforeEach
    void setUp() {
        geradorNumero = new GeradorNumero();
    }

    @Test
    void testGerarNumeroDentroDoLimite() {
        int limite = 50;
        int numero = geradorNumero.gerar(limite);

        assertTrue(numero >= 1, "Número deve ser maior ou igual a 1");
        assertTrue(numero <= limite, "Número deve ser menor ou igual ao limite");
    }

    @Test
    void testGerarMultiplosNumerosVariados() {
        int limite = 100;
        boolean encontrouDiferentes = false;
        int primeiroNumero = geradorNumero.gerar(limite);

        // Testa 100 gerações para verificar aleatoriedade
        for (int i = 0; i < 100; i++) {
            int numero = geradorNumero.gerar(limite);
            assertTrue(numero >= 1 && numero <= limite);

            if (numero != primeiroNumero) {
                encontrouDiferentes = true;
            }
        }

        assertTrue(encontrouDiferentes, "Deve gerar números diferentes (aleatoriedade)");
    }

    @Test
    void testGerarComLimitesPequenos() {
        assertEquals(1, geradorNumero.gerar(1), "Com limite 1, deve retornar 1");

        int numero = geradorNumero.gerar(2);
        assertTrue(numero == 1 || numero == 2, "Com limite 2, deve retornar 1 ou 2");
    }

    @Test
    void testGerarComLimitesGrandes() {
        int limite = 5000;
        int numero = geradorNumero.gerar(limite);

        assertTrue(numero >= 1 && numero <= limite);
    }

    @Test
    void testGerarComDiferentesLimites() {
        // Testa os limites do jogo
        int facil = geradorNumero.gerar(50);
        assertTrue(facil >= 1 && facil <= 50);

        int medio = geradorNumero.gerar(500);
        assertTrue(medio >= 1 && medio <= 500);

        int dificil = geradorNumero.gerar(5000);
        assertTrue(dificil >= 1 && dificil <= 5000);
    }
}
