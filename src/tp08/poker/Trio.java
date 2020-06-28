package tp08.poker;

import java.util.List;

public class Trio extends Jugada{


	@Override
	protected Boolean leGanaATipoDeJugada(Jugada tipoDeJugada) {
		return tipoDeJugada.getClass() == Nada.class;
	}
	
    @Override
    protected boolean esJugada(List<Carta> listaDeCartas) {
		
		return cantidadDeCartasDeDiferenteValor(listaDeCartas) == 3;
	    
	}
    
    @Override
	protected String tipoDeJugada() {
		
		return "Trio";
	}

	@Override
	protected Jugada siguienteJugada() {
		
		return new Nada();
	}

	@Override
	public Integer getValorDeJugada() {
		
		return 0;
	}


}
