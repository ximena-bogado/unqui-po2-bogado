package tp08.poker;


public class Carta {

	private Valor valor;
	private String palo;

	public Carta(Valor valor, String palo) {
		this.valor = valor;
		this.palo = palo;
	}

	public Valor getValor() {
		return valor;
	}
	
	public Integer getValorNumerico() {
		return valor.getValorNumerico();
	}

	public String getPalo() {
		return palo;
	}

	public Boolean esSuperior(Carta carta) {
		
		return this.getValor().esMayor(carta.getValor());
	}

	public Boolean mismoPalo(Carta carta) {
		
		return this.getPalo().equals(carta.getPalo());
	}

}
