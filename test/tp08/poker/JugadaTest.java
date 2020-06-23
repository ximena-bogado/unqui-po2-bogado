package tp08.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp08.poker.Color;
import tp08.poker.Jugada;
import tp08.poker.Nada;
import tp08.poker.Poquer;
import tp08.poker.Trio;

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
		//Exercise
		jugadaPoquer.setValorDeJugada(10);
		jugadaPoquer2.setValorDeJugada(5);
		//Verify
		assertTrue(jugadaPoquer.leGanaA(jugadaPoquer2));
	}
	
	@Test
	void testPoquerNoDesempataPorValorConPoquer() {
		//Exercise
		jugadaPoquer.setValorDeJugada(5);
		jugadaPoquer2.setValorDeJugada(10);
		//Verify
		assertFalse(jugadaPoquer.leGanaA(jugadaPoquer2));
	}

}
