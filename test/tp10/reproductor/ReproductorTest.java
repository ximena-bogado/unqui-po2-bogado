package tp10.reproductor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReproductorTest {
	
	private Song cancion;

	@BeforeEach
	void testSetUp() {
		cancion = new Song();
	}

	@Test
	void testSePonePlayLaCancionYSeReproducePorqueEstaEnModoDeSeleccion() throws IOException {
		cancion.play();
		
		assertEquals(EstadoEnReproduccion.class, cancion.getEstado());
	}
	
	@Test
	void testSePonePlayLaCancionYSeGeneraUnErrorPorqueEstaEnModoDeReproduccion() throws IOException {
		cancion.play();
		try {
			cancion.play();
			fail("Se esperaba una excepcion");
		}catch(IOException e) {
			assertEquals("accion incorrecta", e.getMessage());
		}
		
		assertEquals(EstadoEnReproduccion.class, cancion.getEstado());
	}
	
	@Test
	void testSePonePlayLaCancionYSeGeneraUnErrorPorqueEstaEnModoPausada() throws IOException {
		cancion.play();
		cancion.pause();
		try {
			cancion.play();
			fail("Se esperaba una excepcion");
		}catch(IOException e) {
			assertEquals("accion incorrecta", e.getMessage());
		}
		
		assertEquals(EstadoPausada.class, cancion.getEstado());
	}
	
	@Test
	void testSePonePausaLaCancionYSeQuedaPausadaPorqueEstabaEnModoReproduccion() throws IOException {
		cancion.play();
		cancion.pause();
		
		assertEquals(EstadoPausada.class, cancion.getEstado());
	}
	
	@Test
	void testSePonePausaLaCancionYSeReproducePorqueEstabaEnModoPausada() throws IOException {
		cancion.play();
		cancion.pause();
		cancion.pause();
		
		assertEquals(EstadoEnReproduccion.class, cancion.getEstado());
	}
	
	@Test
	void testSePonePausaLaCancionYSeGeneraUnErrorPorqueEstabaEnModoDeSeleccion() {
		try {
			cancion.pause();
			fail("Se esperaba una excepcion");
		}catch(IOException e) {
			assertEquals("accion incorrecta", e.getMessage());
		}
		
		assertEquals(EstadoSeleccion.class, cancion.getEstado());
	}
	
	@Test
	void testSePoneStopLaCancionEstandoEnModoReproduccionYSePasaAModoSeleccion() throws IOException {
        cancion.play();
		cancion.stop();
		
		assertEquals(EstadoSeleccion.class, cancion.getEstado());
	}
	
	@Test
	void testSePoneStopLaCancionEstandoEnModoPausadaYSePasaAModoSeleccion() throws IOException {
		cancion.play();
		cancion.pause();
		cancion.stop();
		
		assertEquals(EstadoSeleccion.class, cancion.getEstado());
	}
	
	@Test
	void testSePoneStopLaCancionEstandoEnModoSeleccionYNoPasaNada() {
         cancion.stop();
		
		assertEquals(EstadoSeleccion.class, cancion.getEstado());
	}

}
