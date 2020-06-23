package tp08.poker;

public class Color extends Jugada{




	@Override
	public Boolean esJugada(Integer maximo, Boolean palosIguales) {
		
		return palosIguales;
	}

	@Override
	protected Jugada siguienteJugada() {
		
		return new Trio();
	}

	@Override
	protected Boolean leGanaATipoDeJugada(Jugada tipoDeJugada) {
		if (tipoDeJugada.getClass() == Poquer.class){
			return false;
		}else {
			return true;
		}
	}


}
