package tp9.Partidos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ServidorTest {

	private Servidor servidor;

	@Test
	void testSeSuscribeAlDeporteTenis() {
		servidor = new Servidor();
		servidor.suscribirse("Tenis");
		List<String> suscripciones = new ArrayList<String>();
		suscripciones.add("Tenis");
		
		assertEquals(suscripciones, servidor.getSuscripciones());
	}
	
	@Test
	void testSeSuscribeAlDeporteTenisyFutbol() {
		servidor = new Servidor();
		servidor.suscribirse("Tenis");
		servidor.suscribirse("Futbol");
		List<String> suscripciones = new ArrayList<String>();
		suscripciones.add("Tenis");
		suscripciones.add("Futbol");
		
		assertEquals(suscripciones, servidor.getSuscripciones());
	}

}
