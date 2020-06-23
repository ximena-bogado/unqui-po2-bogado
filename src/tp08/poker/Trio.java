package tp08.poker;

public class Trio extends Jugada{

	

	public Trio() {
	}

	@Override
	public Boolean esJugada(Integer maximo, Boolean palosIguales) {
		
		return maximo == 3;
	}

	@Override
	protected Jugada siguienteJugada() {
		
		return new Nada();
	}

	@Override
	protected Boolean leGanaATipoDeJugada(Jugada tipoDeJugada) {
		if (tipoDeJugada.getClass() == Nada.class) {
			return true;
		}else {
			return false;
		}
	}


}
