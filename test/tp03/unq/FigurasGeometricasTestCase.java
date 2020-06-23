package tp03.unq;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp03.unq.Cuadrado;
import tp03.unq.Point;
import tp03.unq.Rectangulo;

class FigurasGeometricasTestCase {

	private Point punto;
	private Rectangulo rectanguloHorizontal;
	private Cuadrado cuadrado;
	
	@BeforeEach
	public void setUp() throws Exception {
		punto = new Point(1,2);
		rectanguloHorizontal = new Rectangulo(punto,6,4);
		cuadrado = new Cuadrado(punto,4);
	}
	
	@Test
	void testConstructorRectangulo() {
		Integer area = rectanguloHorizontal.obtenerElArea();
		Integer perimetro = rectanguloHorizontal.obtenerElPerimetro();
		assertEquals (24,area);
		assertEquals (20,perimetro);
	}
	
	@Test
	void testVerticalOHorizontal() {
		
		assertTrue (rectanguloHorizontal.esHorizontal());
		assertFalse (rectanguloHorizontal.esVertical());
	}
	
	@Test
	void testConstructorCuadrado() {
		Integer area = cuadrado.obtenerElArea();
		Integer perimetro = cuadrado.obtenerElPerimetro();
		assertEquals (16,area);
		assertEquals (16,perimetro);
	}


}
