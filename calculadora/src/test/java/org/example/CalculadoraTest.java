package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass() {
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Suma dos números")
    void testSumar() {
        assertEquals(5, miCalculadora.suma(2, 3));
        assertEquals(-5, miCalculadora.suma(-2, -3));
        assertEquals(-1, miCalculadora.suma(2, -3));
        assertEquals(0, miCalculadora.suma(0, 0));
    }

    @Test
    @DisplayName("Resta dos números")
    void testRestar() {
        assertEquals(2, miCalculadora.resta(5, 3));
        assertEquals(-2, miCalculadora.resta(-5, -3));
        assertEquals(8, miCalculadora.resta(5, -3));
        assertEquals(0, miCalculadora.resta(0, 0));
    }

    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2, 3));
        assertEquals(6, miCalculadora.multiplica(-2, -3));
        assertEquals(-6, miCalculadora.multiplica(2, -3));
        assertEquals(0, miCalculadora.multiplica(0, 5));
    }

    @Test
    @DisplayName("Divide dos números")
    void testDividir() throws Exception {
        assertEquals(2, miCalculadora.divide(6, 3));
        assertEquals(2.5, miCalculadora.divide(10, 4));
        assertEquals(4, miCalculadora.divide(10, 2.5));
        assertEquals(3.2, miCalculadora.divide(8, 2.5));
        assertEquals(0.5, miCalculadora.divide(2, 4));
        assertThrows(Exception.class, () -> {
            miCalculadora.divide(5, 0);
        }, "El divisor es 0");
    }

    @Test
    @DisplayName("Potencia dos números")
    void testPotencia() {
        assertEquals(8, miCalculadora.potencia(2, 3));
        assertEquals(-8, miCalculadora.potencia(-2, 3));
        assertEquals(1, miCalculadora.potencia(2, 0));
        assertEquals(0, miCalculadora.potencia(0, 5));
        assertEquals(1024, miCalculadora.potencia(2, 10));
    }


    @Test
    @DisplayName("Raiz cuadrada")
    void testRaiz() {
        assertEquals(3, miCalculadora.raizCuadrada(9));
        assertEquals(2, miCalculadora.raizCuadrada(4));
        assertEquals(1, miCalculadora.raizCuadrada(1));
        assertEquals(0, miCalculadora.raizCuadrada(0));
        Exception thrown = assertThrows(Exception.class, () -> {
            miCalculadora.raizCuadrada(-1);
        });
        assertEquals("El radicando no puede ser negativo", thrown.getMessage());
    }
}
