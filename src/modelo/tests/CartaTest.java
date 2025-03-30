package modelo.tests;

import modelo.Carta;
import modelo.Carta.Palo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

class CartaTest {

    @Test
    void testGetNumero(TestInfo testInfo) {
        //crear una carta con número 7 y comprobar que getNumero devuelve 7
        Carta card = new Carta(7, Palo.DIAMANTE);
        assertEquals(7, card.getNumero());

        System.out.println("La prueba '" + testInfo.getTestMethod().get().getName() + "' fue completada!");
    }

    @Test
    void testGetPalo(TestInfo testInfo) {
        //crear una carta de palo DIAMANTE y comprobar que getPalo devuelve DIAMANTE
        Carta card = new Carta(7, Palo.DIAMANTE);
        assertEquals(Palo.DIAMANTE, card.getPalo());

        System.out.println("La prueba '" + testInfo.getTestMethod().get().getName() + "' fue completada!");
    }

    @Test
    void testGetValor(TestInfo testInfo) {
        //para una carta con número 7, el valor debería ser 7
        Carta card1 = new Carta(7, Palo.DIAMANTE);
        assertEquals(7, card1.getValor());

        //para un AS(1), el valor debería ser 11
        Carta card2 = new Carta(1, Palo.DIAMANTE);
        assertEquals(11, card2.getValor());

        //para un J(11), el valor debería ser 10
        Carta card3 = new Carta(11, Palo.DIAMANTE);
        assertEquals(10, card3.getValor());

        System.out.println("La prueba '" + testInfo.getTestMethod().get().getName() + "' fue completada!");
    }

    @Test
    void testMostrarNumero(TestInfo testInfo) {
        //para un AS, mostrarNumero debería devolver "AS"
        Carta card1 = new Carta(1, Palo.DIAMANTE);
        assertEquals("AS", card1.mostrarNumero());

        //para una J, mostrarNumero debería devolver "J"
        Carta card2 = new Carta(11, Palo.DIAMANTE);
        assertEquals("J", card2.mostrarNumero());

        //para una Q, mostrarNumero debería devolver "Q"
        Carta card3 = new Carta(12, Palo.DIAMANTE);
        assertEquals("Q", card3.mostrarNumero());

        //para una K, mostrarNumero debería devolver "K"
        Carta card4 = new Carta(13, Palo.DIAMANTE);
        assertEquals("K", card4.mostrarNumero());

        //para cualquier otro número
        Carta card5 = new Carta(8, Palo.DIAMANTE);
        assertEquals("8", card5.mostrarNumero());

        System.out.println("La prueba '" + testInfo.getTestMethod().get().getName() + "' fue completada!");
    }
}