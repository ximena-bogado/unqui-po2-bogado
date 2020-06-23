package tp08.poker;

import java.util.ArrayList;

public class PokerStatus {

	private Jugada jugada;
	private ProcesadorDeCartas procesador;


	public PokerStatus(Poquer jugada, ProcesadorDeCartas procesador) {
		super();
		this.jugada = jugada;
		this.procesador = procesador;
	}


	public Jugada verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
        ArrayList<Carta> listaDeCartas = new ArrayList<Carta>();
		listaDeCartas.add(carta1);
		listaDeCartas.add(carta2);
		listaDeCartas.add(carta3);
		listaDeCartas.add(carta4);
		listaDeCartas.add(carta5);
		
		Integer maximo = procesador.obtenerMaximaRepeticionDeValores(listaDeCartas);
		Boolean palosIguales = procesador.sonPalosIguales(listaDeCartas);
		
		if (jugada.esJugada(maximo, palosIguales)) {
			return jugada;
		}else {
			Jugada jugadaActual = jugada.siguienteJugada();
			this.setJugada(jugadaActual);
			return this.verificar(carta1, carta2, carta3, carta4, carta5);
	    }
	}


	private void setJugada(Jugada jugada) {
		this.jugada = jugada;
	}


}
