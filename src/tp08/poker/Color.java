package tp08.poker;


import java.util.List;

public class Color extends Jugada{


	@Override
	protected Boolean leGanaATipoDeJugada(Jugada tipoDeJugada) {
		return !(tipoDeJugada.getClass() == Poquer.class);
		
	}
	
    @Override
    protected boolean esJugada(List<Carta> listaDeCartas) {
		
		return cantidadDePalosSinRepetidos(listaDeCartas) == 1;
	    
	}
    
    @Override
	protected String tipoDeJugada() {
		
		return "Color";
	}

	@Override
	protected Jugada siguienteJugada() {
		
		return new Trio();
	}

	@Override
	public Integer getValorDeJugada() {
		List<Carta> listaDeCartas = this.getListaDeCartas();
		
		return listaDeCartas.stream().mapToInt(Carta::getValorNumerico).sum();
	}



}
