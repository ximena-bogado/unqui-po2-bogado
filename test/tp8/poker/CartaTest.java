package tp8.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {
	
	private Carta cartaDosDePicas;
	private Carta cartaAceDePicas;
	private Carta cartaKingDeDiamantes;
	private Ace ace;
	private King king;
	private Numerico dos;
	

	@BeforeEach
	void testSetUp() {
		//SetUp
		ace = new Ace();
		king = new King();
		dos = new Numerico(2);
		
		cartaDosDePicas = new Carta(dos, "Picas");
		cartaAceDePicas = new Carta(ace, "Picas");
		cartaKingDeDiamantes = new Carta(king, "Diamantes");
	}
	
	@Test
	void testConstructor() {
		//Verify
		assertEquals(dos, cartaDosDePicas.getValor());
		assertEquals(ace, cartaAceDePicas.getValor());
		
		assertEquals("Picas", cartaDosDePicas.getTipo());
		assertEquals("Diamantes", cartaKingDeDiamantes.getTipo());
		
	}
	
	@Test
	void testLaCartaAceDePicasEsSuperiorQueDosDePicas() {
		//Verify
		assertTrue(cartaAceDePicas.esSuperior(cartaDosDePicas));
		
	}
	
	@Test
	void testLaCartaDosDePicasNoEsSuperiorQueAceDePicas() {
		//Verify
		assertFalse(cartaDosDePicas.esSuperior(cartaAceDePicas));
		
	}
	
	@Test
	void testLaCartaTresDePicasYCartaDosDePicasPoseenElMismoPalo() {
		//Verify
		assertTrue(cartaAceDePicas.mismoPalo(cartaDosDePicas));
		
	}
	
	@Test
	void testLaCartaTresDePicasYCartaCuatroDeDiamantesNoPoseenElMismoPalo() {
		//Verify
		assertFalse(cartaDosDePicas.mismoPalo(cartaKingDeDiamantes));
		
	}
	

}
