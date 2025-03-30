package modelo;

/**
 * esta clase representa una carta de una baraja
 * contiene el número y el palo de la carta
 *
 * @author carrony
 * @version 1.0-fork_marius-db
 */
public class Carta {

    /**
     * este enum representa los palos de la carta
     */
    public enum Palo {
        TREBOL, DIAMANTE, CORAZONES, PICAS
    }

    /**
     * el numero de la carta
     */
    private int numero;

    /**
     * el palo de la carta
     */
    private Palo palo;

    /**
     * crea una nueva carta con el numero y el palo especificados
     * el numero debe estar entre 1 y 13
     *
     * @param numero el número de la carta
     * @param palo   el palo de la carta
     */
    public Carta(int numero, Palo palo) {
        if (numero >= 1 && numero <= 13) {
            this.numero = numero;
            this.palo = palo;
        }
    }

    /**
     * devuelve el número de la carta.
     *
     * @return el número de la carta
     */
    public int getNumero() {
        return numero;
    }

    /**
     * devuelve el palo de la carta.
     *
     * @return el palo de la carta
     */
    public Palo getPalo() {
        return palo;
    }

    /**
     * calcula y devuelve el valor de la carta
     * si el numero de la carta está entre 2 y 10, su valor es igual a su numero
     * si el numero de la carta es 1, su valor es 11
     * en caso contrario, para las cartas de la figura (11, 12, 13), el valor es 10
     *
     * @return el valor calculado de la carta
     */
    public int getValor() {
        int valor;

        if (this.numero >= 2 && this.numero <= 10) {
            valor = this.numero;
        } else if (this.numero == 1) {
            valor = 11;
        } else {
            valor = 10;
        }

        return valor;
    }

    /**
     * devuelve una representación en cadena del numero de la carta
     * si la carta es un as, jota, reina o rey, devuelve la letra correspondiente
     * en caso contrario, devuelve el número en forma de cadena
     *
     * @return la representación en cadena del número de la carta
     */
    public String mostrarNumero() {
        if (this.numero == 1) {
            return "AS";
        } else if (this.numero == 11) {
            return "J";
        } else if (this.numero == 12) {
            return "Q";
        } else if (this.numero == 13) {
            return "K";
        }
        return "" + this.numero;
    }

    /**
     * devuelve una representación en cadena de la carta.
     *
     * @return la representación en cadena de la carta
     */
    @Override
    public String toString() {
        return "[" + mostrarNumero() + " - " + palo + "]";
    }
}
