package tp08.poker;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JugadaTest {

	private Jugada jugadaPoquer;
	private Jugada jugadaColor;
	private Jugada jugadaTrio;
	private Jugada jugadaNada;
	private Poquer jugadaPoquer2;

	@BeforeEach
	void testSetUp() {
		//SetUp
		jugadaPoquer = new Poquer();
		jugadaColor = new Color();
		jugadaTrio = new Trio();
		jugadaNada = new Nada();
		jugadaPoquer2 = new Poquer();
		
	}
	
	@Test
	void testPoquerLeGanaAColor() {
		//Verify
		assertTrue(jugadaPoquer.leGanaA(jugadaColor));
	}
	
	@Test
	void testColorNoLeGanaAPoquer() {
		//Verify
		assertFalse(jugadaColor.leGanaA(jugadaPoquer));
	}
	
	@Test
	void testColorLeGanaATrio() {
		//Verify
		assertTrue(jugadaColor.leGanaA(jugadaTrio));
	}
	
	@Test
	void testColorLeGanaANada() {
		//Verify
		assertTrue(jugadaColor.leGanaA(jugadaNada));
	}
	
	@Test
	void testTrioLeGanaANada() {
		//Verify
		assertTrue(jugadaTrio.leGanaA(jugadaNada));
	}
	
	@Test
	void testTrioNoLeGanaAColor() {
		//Verify
		assertFalse(jugadaTrio.leGanaA(jugadaColor));
	}
	
	@Test
	void testTrioNoLeGanaAPoquer() {
		//Verify
		assertFalse(jugadaTrio.leGanaA(jugadaPoquer));
	}
	
	@Test
	void testNadaNoLeGanaATrio() {
		//Verify
		assertFalse(jugadaNada.leGanaA(jugadaTrio));
	}
	
	@Test
	void testPoquerDesempataPorValorConPoquer() {
		Carta carta1 = mock(Carta.class);
		Carta carta2 = mock(Carta.class);
		Carta carta3 = mock(Carta.class);
		Carta carta4 = mock(Carta.class);
		Carta carta5 = mock(Carta.class);
		Carta carta6 = mock(Carta.class);
		Carta carta7 = mock(Carta.class);
		Carta carta8 = mock(Carta.class);
		Carta carta9 = mock(Carta.class);
		Carta carta10 = mock(Carta.class);
		
		List<Carta> listaDeCartas1 = List.of(carta1, carta2, carta3, carta4, carta5);
		List<Carta> listaDeCartas2 = List.of(carta6, carta7, carta8, carta9, carta10);
		
		//Exercise
		when(carta1.getValorNumerico()).thenReturn(2);
		when(carta2.getValorNumerico()).thenReturn(2);
		when(carta3.getValorNumerico()).thenReturn(2);
		when(carta4.getValorNumerico()).thenReturn(2);
		when(carta5.getValorNumerico()).thenReturn(1);
		when(carta6.getValorNumerico()).thenReturn(9);
		when(carta7.getValorNumerico()).thenReturn(1);
		when(carta8.getValorNumerico()).thenReturn(1);
		when(carta9.getValorNumerico()).thenReturn(1);
		when(carta10.getValorNumerico()).thenReturn(1);
		
		jugadaPoquer.setCartas(listaDeCartas1);
		jugadaPoquer2.setCartas(listaDeCartas2);
		//Verify
		assertTrue(jugadaPoquer.leGanaA(jugadaPoquer2));
	}
	
	@Test
	void testPoquerNoDesempataPorValorConPoquer2() {
		Carta carta1 = mock(Carta.class);
		Carta carta2 = mock(Carta.class);
		Carta carta3 = mock(Carta.class);
		Carta carta4 = mock(Carta.class);
		Carta carta5 = mock(Carta.class);
		Carta carta6 = mock(Carta.class);
		Carta carta7 = mock(Carta.class);
		Carta carta8 = mock(Carta.class);
		Carta carta9 = mock(Carta.class);
		Carta carta10 = mock(Carta.class);
		
		List<Carta> listaDeCartas1 = List.of(carta1, carta2, carta3, carta4, carta5);
		List<Carta> listaDeCartas2 = List.of(carta6, carta7, carta8, carta9, carta10);
		
		//Exercise
		when(carta1.getValorNumerico()).thenReturn(1);
		when(carta2.getValorNumerico()).thenReturn(1);
		when(carta3.getValorNumerico()).thenReturn(1);
		when(carta4.getValorNumerico()).thenReturn(1);
		when(carta5.getValorNumerico()).thenReturn(9);
		when(carta6.getValorNumerico()).thenReturn(1);
		when(carta7.getValorNumerico()).thenReturn(2);
		when(carta8.getValorNumerico()).thenReturn(2);
		when(carta9.getValorNumerico()).thenReturn(2);
		when(carta10.getValorNumerico()).thenReturn(2);
		
		
		jugadaPoquer.setCartas(listaDeCartas1);
		jugadaPoquer2.setCartas(listaDeCartas2);
		
		//Verify
		assertFalse(jugadaPoquer.leGanaA(jugadaPoquer2));
	}

}
