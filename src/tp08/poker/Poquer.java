package tp08.poker;


public class Poquer extends Jugada{




	@Override
	public Boolean esJugada(Integer maximo, Boolean palosIguales) {
		
		return maximo >= 4;
	}

	@Override
	protected Jugada siguienteJugada() {
		
		return new Color();
	}

	@Override
	protected Boolean leGanaATipoDeJugada(Jugada tipoDeJugada) {
		
		return true;
	}

	


	
}

