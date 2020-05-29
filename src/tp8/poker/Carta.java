package tp8.poker;


public class Carta {

	private Valor valor;
	private String tipo;

	public Carta(Valor valor, String tipo) {
		this.valor = valor;
		this.tipo = tipo;
	}

	public Valor getValor() {
		return valor;
	}

	public String getTipo() {
		return tipo;
	}

	public Boolean esSuperior(Carta carta) {
		
		return this.getValor().esMayor(carta.getValor());
	}

	public Boolean mismoPalo(Carta carta) {
		
		return this.getTipo().equals(carta.getTipo());
	}

}
