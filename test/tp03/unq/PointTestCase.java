package tp03.unq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp03.unq.Point;

class PointTestCase {
	
	private Point punto;
	private Point punto2;
	
	@BeforeEach
	public void setUp() throws Exception {
		punto = new Point();
		punto2 = new Point(1,2);
	}
	

	@Test
	void testConstructor() {
		float puntoX= punto.getX();
        assertEquals (0,puntoX);
        float puntoY= punto.getY();
        assertEquals (0,puntoY);
        
        float punto2X= punto2.getX();
        assertEquals (1,punto2X);
        float punto2Y= punto2.getY();
        assertEquals (2,punto2Y);
	}
	
	@Test
	public void testMoverPunto(){
        punto.setXY(4,5);
        float puntoNuevoX= punto.getX();
        assertEquals (4,puntoNuevoX);
        float puntoNuevoY= punto.getY();
        assertEquals (5,puntoNuevoY);
	}

	
	@Test
	public void testSumarPuntos(){
		punto.setXY(4,5);
        Point nuevoPunto = punto.sumarseConOtroPunto(punto2);
        float nuevoPuntoX= nuevoPunto.getX();
        assertEquals (5,nuevoPuntoX);
        float nuevoPuntoY= nuevoPunto.getY();
        assertEquals (7,nuevoPuntoY);
	}
	
	
}
