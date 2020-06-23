package tp08.poker;

public class Nada extends Jugada{




	@Override
	public Boolean esJugada(Integer maximo, Boolean palosIguales) {
		
		return true;
	}

	@Override
	protected Jugada siguienteJugada() {
		
		return null;
	}

	@Override
	protected Boolean leGanaATipoDeJugada(Jugada tipoDeJugada) {
		
		return false;
	}

}
