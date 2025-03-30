package modelo.tests;

import java.util.ArrayList;
import java.util.List;

import modelo.Mano;
import modelo.Mazo;
import modelo.Carta;
import modelo.Carta.Palo;

import excepciones.NoHayMasCartasException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.*;

class ManoTest {

    //clase Mano para las pruebas
    static class ManoForTest extends Mano {
        void addCartaToMano(Carta c){
            cartas.add(c);
        }
        int getManoSize(){
            return cartas.size();
        }
        Carta getCartaAt(int i){
            return cartas.get(i);
        }
    }

    //clase Mazo para las pruebas
    static class MazoForTest extends Mazo {

        //establecer lista personalizada de cartas sin acceder a cartas desde fuera
        void setCartas(List<Carta> cartasList) {
            this.cartas = cartasList;
        }
    }

    //clase Carta para las pruebas
    static class CartaForTest extends Carta {
        public CartaForTest(int valor, Palo palo) {
            super(valor, palo);
        }
    }

    //pruebas:

    @Test
    void valorMano(TestInfo testInfo){
        ManoForTest hand = new ManoForTest();

        //añadiendo cartas de prueba
        hand.addCartaToMano(new CartaForTest(5, Palo.CORAZONES));
        hand.addCartaToMano(new CartaForTest(7, Palo.DIAMANTE));

        assertEquals(12, hand.valorMano());

        System.out.println("La prueba '" + testInfo.getTestMethod().get().getName() + "' fue completada!");
    }

    @Test
    void finDeJuego(TestInfo testInfo){
        ManoForTest hand = new ManoForTest();

        //añadiendo carta de prueba para llegar a 21
        hand.addCartaToMano(new CartaForTest(10, Palo.CORAZONES));
        hand.addCartaToMano(new CartaForTest(5, Palo.DIAMANTE));

        //prueba
        assertFalse(hand.finDeJuego());

        //añadiendo carta de prueba para llegar a 21
        hand.addCartaToMano(new CartaForTest(6, Palo.DIAMANTE));

        //prueba
        assertTrue(hand.finDeJuego());

        System.out.println("La prueba '" + testInfo.getTestMethod().get().getName() + "' fue completada!");
    }

    @Test
    void pedirCarta(TestInfo testInfo) throws NoHayMasCartasException {
        MazoForTest mazo = new MazoForTest();

        //mazo de cartas de prueba sin acceder a las cartas directamente, por lo que no tengo que cambiar el código original, ya que me pedía que hiciera públicas las "cartas"
        List<Carta> customCards = new ArrayList<>();

        customCards.add(new CartaForTest(5, Palo.CORAZONES));
        customCards.add(new CartaForTest(8, Palo.DIAMANTE));
        mazo.setCartas(customCards);

        ManoForTest mano = new ManoForTest();
        mano.pedirCarta(mazo);

        assertEquals(1, mano.getManoSize());
        assertEquals(5, mano.getCartaAt(0).getValor());

        System.out.println("La prueba '" + testInfo.getTestMethod().get().getName() + "' fue completada!");
    }
}