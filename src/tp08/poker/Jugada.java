package tp08.poker;

public abstract class Jugada {
	
	private int valorDeJugada;

	public abstract Boolean esJugada(Integer maximo, Boolean palosIguales);

    protected abstract Jugada siguienteJugada();

	protected Boolean leGanaA(Jugada tipoDeJugada) {
		if (this.getClass() == tipoDeJugada.getClass()) {
			return this.desempataPorValor(tipoDeJugada);
		}else {
			return this.leGanaATipoDeJugada(tipoDeJugada);
		}

	}
	
	protected abstract Boolean leGanaATipoDeJugada(Jugada tipoDeJugada);

	protected Boolean desempataPorValor(Jugada tipoDeJugada) {
		
		return this.valorDeJugada > tipoDeJugada.valorDeJugada;
	}

	public void setValorDeJugada(int i) {
		this.valorDeJugada = i;
		
	}


}
