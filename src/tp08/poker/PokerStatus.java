package tp08.poker;


import java.util.List;

public class PokerStatus {


	public Jugada verificar(Carta carta1, Carta carta2, Carta carta3, Carta carta4, Carta carta5) {
        List<Carta> listaDeCartas = List.of(carta1, carta2, carta3, carta4, carta5);
        
        Jugada jugadaActual = new Poquer();
        while (!jugadaActual.esJugada(listaDeCartas)) {
        	jugadaActual = jugadaActual.siguienteJugada();
        }
        
        jugadaActual.setCartas(listaDeCartas);
        return jugadaActual;
        
        /*return jugadas.stream().filter(j -> j.esJugada(listaDeCartas)).collect(Collectors.toList()).get(0);*/

	}
	
	public Jugada jugadaGanadora(Jugada jugada1, Jugada jugada2  ) {
		if (jugada1.leGanaA(jugada2)) {
			return jugada1;
		}else {
			return jugada2;
		}
	}



}
