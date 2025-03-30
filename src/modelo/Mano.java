package modelo;

import java.util.ArrayList;

import excepciones.NoHayMasCartasException;

/**
 * esta clase representa una mano de cartas y extiende de la clase mazo.
 * se utiliza para gestionar una colección de cartas en el juego.
 *
 * @author carrony
 * @version 1.0-fork_marius-db
 */

public class Mano extends Mazo {

    /**
     * constructor por defecto que inicializa la mano con una lista vacia de cartas
     */

    public Mano() {
        this.cartas = new ArrayList<Carta>();
    }

    /**
     * calcula y devuelve el valor total de la mano sumando el valor de cada carta
     *
     * @return el valor total de la mano
     */
    public int valorMano() {
        int valor = 0;
        for (Carta carta : this.cartas) {
            valor = valor + carta.getValor();
        }
        return valor;
    }

    /**
     * determina si se ha alcanzado el fin del juego
     * se considera fin del juego si el valor de la mano es mayor o igual a 21
     *
     * @return verdadero si el valor de la mano es mayor o igual a 21, falso en caso contrario
     */
    public boolean finDeJuego() {
        if (this.valorMano() >= 21) {
            return true;
        }
        return false;
    }

    /**
     * devuelve una representación en cadena de la mano incluyendo el valor total
     * y la representacion en cadena de las cartas contenidas en el mazo
     *
     * @return la representación en cadena de la mano
     */
    @Override
    public String toString() {
        String res = "Valor de la Mano: " + this.valorMano() + "\n";
        res = res + super.toString();
        return res;
    }

    /**
     * solicita una carta a un mazo y la anade a la mano
     *
     * @param m el mazo desde el cual se solicita la carta
     * @throws NoHayMasCartasException si el mazo no tiene más cartas disponibles
     */
    public void pedirCarta(Mazo m) throws NoHayMasCartasException {
        Carta c = m.solicitarCarta();
        this.cartas.add(c);
    }
}