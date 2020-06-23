package tp08.poker;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import tp08.poker.Carta;
import tp08.poker.Color;
import tp08.poker.Jugada;
import tp08.poker.Nada;
import tp08.poker.PokerStatus;
import tp08.poker.Poquer;
import tp08.poker.ProcesadorDeCartas;
import tp08.poker.Trio;

class PokerStatusTest {
	
	private PokerStatus pokerStatus;
	private Carta carta1;
	private Carta carta2;
	private Carta carta3;
	private Carta carta4;
	private Carta carta5;
	private Poquer jugadaPoquer;
	private Color jugadaColor;
	private Trio jugadaTrio;
	private Nada jugadaNada;
	private ProcesadorDeCartas procesador;
	private List<Carta> listaDeCartas;

	@BeforeEach
	void testSetUp() {
		//SetUp
		//Doc
		//Por ahora son Dummy hasta que les doy comportamiento y se convierten en Stub
		jugadaPoquer = mock(Poquer.class);
		jugadaColor = mock(Color.class);
		jugadaTrio = mock(Trio.class);
		jugadaNada = mock(Nada.class);
		procesador = mock(ProcesadorDeCartas.class);
		
		//Dummy
		carta1 = mock(Carta.class);
		carta2 = mock(Carta.class);
		carta3 = mock(Carta.class);
		carta4 = mock(Carta.class);
		carta5 = mock(Carta.class);
		//Sut
		this.pokerStatus = new PokerStatus(jugadaPoquer, procesador);
		
		listaDeCartas = new ArrayList<Carta>();
		listaDeCartas.add(carta1);
		listaDeCartas.add(carta2);
		listaDeCartas.add(carta3);
		listaDeCartas.add(carta4);
		listaDeCartas.add(carta5);
		
	}

	@Test
	void testVerificarCartasConDiferentesValoresDaNada() {
		//SetUp
		
		//Exercise
		//Stub
		// usando when estas preparando el objeto mock a recibir el mensaje sin importar el orden y si lo llaman
		when(procesador.obtenerMaximaRepeticionDeValores(listaDeCartas)).thenReturn(1);
		when(procesador.sonPalosIguales(listaDeCartas)).thenReturn(false);
		when(jugadaPoquer.esJugada(1,false)).thenReturn(false);
		when(jugadaPoquer.siguienteJugada()).thenReturn(jugadaColor);
		when(jugadaColor.esJugada(1,false)).thenReturn(false);
		when(jugadaColor.siguienteJugada()).thenReturn(jugadaTrio);
		when(jugadaTrio.esJugada(1,false)).thenReturn(false);
		when(jugadaTrio.siguienteJugada()).thenReturn(jugadaNada);
		when(jugadaNada.esJugada(1,false)).thenReturn(true);
		//
		Jugada verificacion = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertEquals(jugadaNada, verificacion);
		
	}
	
	@Test
	void testVerificar4CartasConMismoValorDaPoquer() {
		//SetUp
		
		//Exercise
		//Stub
		when(procesador.obtenerMaximaRepeticionDeValores(listaDeCartas)).thenReturn(4);
		when(procesador.sonPalosIguales(listaDeCartas)).thenReturn(false);
		when(jugadaPoquer.esJugada(4,false)).thenReturn(true);
		InOrder enOrder = inOrder(jugadaPoquer);
		
		Jugada verificacion = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertEquals(jugadaPoquer, verificacion);
		
		//ejemplo de como verificar que se recibio una secuencia de mensajes en un orden particular
		//Mock-Stub con capacidad de verificarse
		//enOrder.verify(procesador).obtenerMaximaRepeticionDeValores(listaDeCartas);
		//enOrder.verify(procesador).sonPalosIguales(listaDeCartas);
		// forma de verificar con mock verify(mock).methodCall
		// no se puede anidar mensajes diferentes pero si el mismo mensaje con: when(methodCall).thenReturn(value, value)
		
	}
	
	@Test
	void testVerificar3CartasConMismoValorY2CartasConValorDiferenteDaTrio() {
		//SetUp
		
		//Exercise
		//Stub
		when(procesador.obtenerMaximaRepeticionDeValores(listaDeCartas)).thenReturn(3);
		when(procesador.sonPalosIguales(listaDeCartas)).thenReturn(false);
		when(jugadaPoquer.esJugada(3,false)).thenReturn(false);
		when(jugadaPoquer.siguienteJugada()).thenReturn(jugadaColor);
		when(jugadaColor.esJugada(3,false)).thenReturn(false);
		when(jugadaColor.siguienteJugada()).thenReturn(jugadaTrio);
		when(jugadaTrio.esJugada(3,false)).thenReturn(true);
		
		Jugada verificacion = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertEquals(jugadaTrio, verificacion);
		
	}
	
	@Test
	void testVerificar5CartasConMismoPaloDaColor() {
		//SetUp
		
		
		//Exercise
		//Stub
		when(procesador.obtenerMaximaRepeticionDeValores(listaDeCartas)).thenReturn(1);
		when(procesador.sonPalosIguales(listaDeCartas)).thenReturn(true);
		when(jugadaPoquer.esJugada(1,true)).thenReturn(false);
		when(jugadaPoquer.siguienteJugada()).thenReturn(jugadaColor);
		when(jugadaColor.esJugada(1,true)).thenReturn(true);
		
		Jugada verificacion = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertEquals(jugadaColor, verificacion);
		
	}


}
