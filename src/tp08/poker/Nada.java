package tp08.poker;

import java.util.List;

public class Nada extends Jugada{


	@Override
	protected Boolean leGanaATipoDeJugada(Jugada tipoDeJugada) {
		
		return false;
	}
	
    @Override
    protected boolean esJugada(List<Carta> listaDeCartas) {
		
		return true;
	    
	}
    
    @Override
	protected String tipoDeJugada() {
		
		return "Nada";
	}

	@Override
	protected Jugada siguienteJugada() {
		
		return null;
	}

	@Override
	public Integer getValorDeJugada() {
		// TODO Auto-generated method stub
		return 0;
	}


}
