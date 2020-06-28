package tp08.poker;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PokerStatusTest {
	
	private PokerStatus pokerStatus;
	private Carta carta1;
	private Carta carta2;
	private Carta carta3;
	private Carta carta4;
	private Carta carta5;

	@BeforeEach
	void testSetUp() {
		//SetUp
		//Doc
		//Por ahora son Dummy hasta que les doy comportamiento y se convierten en Stub
		carta1 = mock(Carta.class);
		carta2 = mock(Carta.class);
		carta3 = mock(Carta.class);
		carta4 = mock(Carta.class);
		carta5 = mock(Carta.class);
		//Sut
		this.pokerStatus = new PokerStatus();
		
	}

	@Test
	void testVerificarCartasConDiferentesValoresDaNada() {
		//SetUp
		
		//Exercise
		//Stub
		// usando when estas preparando el objeto mock a recibir el mensaje sin importar el orden y si lo llaman
		when(carta1.getValorNumerico()).thenReturn(1);
		when(carta1.getPalo()).thenReturn("Corazones");
		when(carta2.getValorNumerico()).thenReturn(2);
		when(carta2.getPalo()).thenReturn("Picas");
		when(carta3.getValorNumerico()).thenReturn(3);
		when(carta3.getPalo()).thenReturn("Picas");
		when(carta4.getValorNumerico()).thenReturn(4);
		when(carta4.getPalo()).thenReturn("Picas");
		when(carta5.getValorNumerico()).thenReturn(5);
		when(carta5.getPalo()).thenReturn("Picas");
		//
		Jugada verificacion = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertEquals("Nada", verificacion.tipoDeJugada());
		
	}
	
	@Test
	void testVerificar4CartasConMismoValorDaPoquer() {
		//SetUp
		
		//Exercise
		//Stub
		when(carta1.getValorNumerico()).thenReturn(1);
		when(carta1.getPalo()).thenReturn("Corazones");
		when(carta2.getValorNumerico()).thenReturn(1);
		when(carta2.getPalo()).thenReturn("Picas");
		when(carta3.getValorNumerico()).thenReturn(1);
		when(carta3.getPalo()).thenReturn("Picas");
		when(carta4.getValorNumerico()).thenReturn(1);
		when(carta4.getPalo()).thenReturn("Picas");
		when(carta5.getValorNumerico()).thenReturn(5);
		when(carta5.getPalo()).thenReturn("Picas");
		
		Jugada verificacion = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertEquals("Poquer", verificacion.tipoDeJugada());
		
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
		when(carta1.getValorNumerico()).thenReturn(1);
		when(carta1.getPalo()).thenReturn("Corazones");
		when(carta2.getValorNumerico()).thenReturn(1);
		when(carta2.getPalo()).thenReturn("Picas");
		when(carta3.getValorNumerico()).thenReturn(1);
		when(carta3.getPalo()).thenReturn("Picas");
		when(carta4.getValorNumerico()).thenReturn(4);
		when(carta4.getPalo()).thenReturn("Picas");
		when(carta5.getValorNumerico()).thenReturn(5);
		when(carta5.getPalo()).thenReturn("Picas");
		
		Jugada verificacion = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertEquals("Trio", verificacion.tipoDeJugada());
		
	}
	
	@Test
	void testVerificar5CartasConMismoPaloDaColor() {
		//SetUp
		
		
		//Exercise
		//Stub
		when(carta1.getValorNumerico()).thenReturn(1);
		when(carta1.getPalo()).thenReturn("Picas");
		when(carta2.getValorNumerico()).thenReturn(1);
		when(carta2.getPalo()).thenReturn("Picas");
		when(carta3.getValorNumerico()).thenReturn(7);
		when(carta3.getPalo()).thenReturn("Picas");
		when(carta4.getValorNumerico()).thenReturn(4);
		when(carta4.getPalo()).thenReturn("Picas");
		when(carta5.getValorNumerico()).thenReturn(5);
		when(carta5.getPalo()).thenReturn("Picas");
		
		Jugada verificacion = pokerStatus.verificar(carta1, carta2, carta3, carta4, carta5);
		//Verify
		assertEquals("Color", verificacion.tipoDeJugada());
		
	}
	
	@Test
	void testJugadaUnoLeGanaAJugadaDos() {
		//SetUp
		Jugada jugada1 = mock(Jugada.class);
		Jugada jugada2 = mock(Jugada.class);
		//Exercise
		//Stub
		when(jugada1.leGanaA(jugada2)).thenReturn(true);
		
		//Verify
		assertEquals(jugada1, pokerStatus.jugadaGanadora(jugada1, jugada2));
		
	}
	
	@Test
	void testJugadaUnoNoLeGanaAJugadaDos() {
		//SetUp
		Jugada jugada1 = mock(Jugada.class);
		Jugada jugada2 = mock(Jugada.class);
		//Exercise
		//Stub
		when(jugada1.leGanaA(jugada2)).thenReturn(false);
		
		//Verify
		assertEquals(jugada2, pokerStatus.jugadaGanadora(jugada1, jugada2));
		
	}


}
