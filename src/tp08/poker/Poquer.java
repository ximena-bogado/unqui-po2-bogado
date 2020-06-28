package tp08.poker;

import java.util.List;

public class Poquer extends Jugada{


	@Override
	protected Boolean leGanaATipoDeJugada(Jugada tipoDeJugada) {
		
		return true;
	}

	@Override
	protected boolean esJugada(List<Carta> listaDeCartas) {
		
		return cantidadDeCartasDeDiferenteValor(listaDeCartas) <= 2;
	    
	}

	@Override
	protected String tipoDeJugada() {
		
		return "Poquer";
	}

	@Override
	protected Jugada siguienteJugada() {
		
		return new Color();
	}

	@Override
	public Integer getValorDeJugada() {
		
		return this.valorRepetido(this.getListaDeCartas()) * 4;
	}

}

