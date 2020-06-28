package tp08.poker;


import java.util.Collections;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public abstract class Jugada {
	
	private List<Carta> listaDeCartas;

	protected Boolean leGanaA(Jugada tipoDeJugada) {
		if (this.getClass() == tipoDeJugada.getClass()) {
			return this.desempataPorValor(tipoDeJugada);
		}else {
			return this.leGanaATipoDeJugada(tipoDeJugada);
		}

	}

	protected Boolean desempataPorValor(Jugada tipoDeJugada) {
		
		return this.getValorDeJugada() > tipoDeJugada.getValorDeJugada();
	}

	
	public List<Carta> getListaDeCartas() {
		return listaDeCartas;
	}
	
	protected Integer cantidadDeCartasDeDiferenteValor(List<Carta> listaDeCartas) {
		return listaDeCartas.stream().map(c -> c.getValorNumerico()).collect(Collectors.toSet()).size();
	}
	
	protected Integer cantidadDePalosSinRepetidos(List<Carta> listaDeCartas) {
		return listaDeCartas.stream().map(c -> c.getPalo()).collect(Collectors.toSet()).size();
	}
	
	public void setCartas(List<Carta> listaDeCartas) {
		
		this.listaDeCartas = listaDeCartas;
	}
	
	protected Integer valorRepetido(List<Carta> listaDeCartas) {
		List<Integer> valores = valoresDeCartas(listaDeCartas);
		
		return listaDeCartas
				.stream()
				.map(Carta::getValorNumerico)
				.reduce(BinaryOperator.maxBy((o1, o2) -> Collections.frequency(valores, o1) - Collections.frequency(valores, o2)))
				.orElse(null);
	}

	private List<Integer> valoresDeCartas(List<Carta> listaDeCartas) {
		
		return listaDeCartas.stream().map(Carta::getValorNumerico).collect(Collectors.toList());
	}

	protected abstract String tipoDeJugada();
	
	protected abstract boolean esJugada(List<Carta> listaDeCartas);
	
	protected abstract Boolean leGanaATipoDeJugada(Jugada tipoDeJugada);

	protected abstract Jugada siguienteJugada();

	public abstract Integer getValorDeJugada();




}
