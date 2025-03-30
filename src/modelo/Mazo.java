package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Carta.Palo;
import excepciones.NoHayMasCartasException;

/**
 * esta clase representa un mazo de cartas
 * se encarga de inicializar, barajar y gestionar la entrega de cartas
 *
 * @author carrony
 * @version 1.0-fork_marius-db
 */

public class Mazo {

    /**
     * lista de cartas que conforman el mazo
     */
    protected List<Carta> cartas;

    /**
     * constructor por defecto que inicializa el mazo con todas las cartas de cada palo
     */
    public Mazo() {
        this.cartas = new ArrayList<Carta>();
        for (Palo palo : Palo.values()) {
            for (int i = 1; i <= 13; i++) {
                Carta carta = new Carta(i, palo);
                this.cartas.add(carta);
            }
        }
    }

    /**
     * baraja las cartas del mazo de forma aleatoria
     */
    public void barajar() {
        Collections.shuffle(cartas);
    }

    /**
     * devuelve una representación en cadena del mazo, mostrando cada carta en una línea
     *
     * @return la representación en cadena del mazo
     */
    @Override
    public String toString() {
        String res = "";
        for (Carta carta : cartas) {
            res = res + carta.toString() + "\n";
        }
        return res;
    }

    /**
     * solicita y devuelve la primera carta del mazo; la carta es removida del mazo
     *
     * @return la primera carta del mazo
     * @throws NoHayMasCartasException si el mazo está vacío y no se pueden solicitar más cartas
     */
    public Carta solicitarCarta() throws NoHayMasCartasException {
        if (this.cartas.isEmpty()) {
            throw new NoHayMasCartasException();
        }
        Carta carta = this.cartas.getFirst();
        this.cartas.removeFirst();
        return carta;
    }
}