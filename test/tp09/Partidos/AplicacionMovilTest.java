package tp09.Partidos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class AplicacionMovilTest {

	private AplicacionMovil aplicacion;

	@Test
	void testSeSuscribeAlDeporteTenis() {
		aplicacion = new AplicacionMovil();
		aplicacion.suscribirse("Tenis");
		List<String> suscripciones = new ArrayList<String>();
		suscripciones.add("Tenis");
		
		assertEquals(suscripciones, aplicacion.getSuscripciones());
	}
	
	@Test
	void testSeSuscribeAlDeporteTenisyAlContrincanteNadal() {
		aplicacion = new AplicacionMovil();
		aplicacion.suscribirse("Tenis");
		aplicacion.suscribirse("Nadal");
		List<String> suscripciones = new ArrayList<String>();
		suscripciones.add("Tenis");
		suscripciones.add("Nadal");
		
		assertEquals(suscripciones, aplicacion.getSuscripciones());
	}

}
