package modelo.tests;

import modelo.Mazo;

import excepciones.NoHayMasCartasException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MazoTest {

    @Test
    void barajar() {
        Mazo deck = new Mazo();
        String before = deck.toString();
        deck.barajar();
        String after = deck.toString();

        //verificar que el número de cartas se mantiene
        String[] cardsBefore = before.split("\n");
        String[] cardsAfter = after.split("\n");

        assertEquals(cardsBefore.length, cardsAfter.length);

        //en caso de que por alguna razón el barajar resulte en el mismo orden, lo cual es astronómicamente improbable, pero supongo que agregaré esto para estar seguro xD
        if (before.equals(after)) {
            deck.barajar();
            after = deck.toString();
        }

        assertNotEquals(before, after);
    }

    @Test
    void solicitarCarta() throws NoHayMasCartasException {
        Mazo deck = new Mazo();
        for (int i = 0; i < 52; i++) {
            assertNotNull(deck.solicitarCarta());
        }
        //verificar que al solicitar otra carta se lanza la exception
        assertThrows(NoHayMasCartasException.class, deck::solicitarCarta);
    }
}