package tp08.poker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartaTest {
	
	private Carta cartaDosDePicas;
	private Carta cartaAceDePicas;
	private Carta cartaKingDeDiamantes;
	private Valor ace;
	private Valor king;
	private Valor dos;
	

	@BeforeEach
	void testSetUp() {
		//SetUp
		ace = ValorTextual.ACE;
		king = ValorTextual.KING;
		dos = new ValorNumerico(2);
		
		cartaDosDePicas = new Carta(dos, "Picas");
		cartaAceDePicas = new Carta(ace, "Picas");
		cartaKingDeDiamantes = new Carta(king, "Diamantes");
	}
	
	@Test
	void testConstructor() {
		//Verify
		assertEquals(dos, cartaDosDePicas.getValor());
		assertEquals(ace, cartaAceDePicas.getValor());
		
		assertEquals("Picas", cartaDosDePicas.getPalo());
		assertEquals("Diamantes", cartaKingDeDiamantes.getPalo());
		
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
