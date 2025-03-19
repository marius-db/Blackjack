package modelo;

public class Carta {

	public enum Palo {
			TREBOl, DIAMANTE ,CORAZONES, PICAS
	}
	
	private int numero;
	private Palo palo;
	
	
	public Carta(int numero, Palo palo) {
		if (numero>=1 && numero<=13) {
			this.numero = numero;
			this.palo = palo;
		}
	}

	public int getNumero() {
		return numero;
	}

	public Palo getPalo() {
		return palo;
	}
	
	public int getValor() {
		int valor;
		
		if (this.numero>=2 && this.numero<=10) {
			valor=this.numero;
		} else if (this.numero==1){
			valor=11;
		} else {
			valor=10;
		}

		return valor;
	}
	
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

	@Override
	public String toString() {
		return "["+ mostrarNumero() + " - " + palo + "]";
	}

}
