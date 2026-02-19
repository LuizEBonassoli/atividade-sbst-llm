import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraCustoTest {

    private CalculadoraCusto calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new CalculadoraCusto();
    }

    @Test
    void deveLancarExcecaoQuandoPesoZero() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularFrete(0, false)
        );

        assertEquals("Peso invalido", ex.getMessage());
    }

    @Test
    void deveLancarExcecaoQuandoPesoNegativo() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularFrete(-5, true)
        );
    }

    @Test
    void deveCalcularFreteNormalParaPesoMenorQueDez() {
        double resultado = calculadora.calcularFrete(5, false);
        assertEquals(25.0, resultado);
    }

    @Test
    void deveCalcularFreteNormalParaPesoIgualDez() {
        double resultado = calculadora.calcularFrete(10, false);
        assertEquals(50.0, resultado);
    }

    @Test
    void deveAplicarDescontoQuandoPesoMaiorQueDez() {
        double resultado = calculadora.calcularFrete(20, false);
        assertEquals(90.0, resultado);
    }

    @Test
    void deveAdicionarTaxaExpressoParaPesoMenorQueDez() {
        double resultado = calculadora.calcularFrete(5, true);
        assertEquals(45.0, resultado);
    }

    @Test
    void deveAdicionarTaxaExpressoParaPesoMaiorQueDezSemDesconto() {
        double resultado = calculadora.calcularFrete(20, true);
        assertEquals(120.0, resultado);
    }

    @Test
    void deveCalcularFreteParaPesoMinimoValido() {
        double resultado = calculadora.calcularFrete(0.0001, false);
        assertEquals(0.0005, resultado, 0.0000001);
    }

    @Test
    void deveCalcularFreteComPrecisaoDecimal() {
        double resultado = calculadora.calcularFrete(10.5, false);
        assertEquals(47.25, resultado, 0.0001);
    }
}

