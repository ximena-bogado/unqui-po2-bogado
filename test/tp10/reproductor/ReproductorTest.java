package tp10.reproductor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReproductorTest {
	
	private Reproductor cancion;
	private Song song;

	@BeforeEach
	void testSetUp() {
		cancion = new Reproductor();
		song = mock(Song.class);
	}

	@Test
	void testSePonePlayLaCancionYSeReproducePorqueEstaEnModoDeSeleccion() throws IOException {
		cancion.play(song);
		
		assertEquals("En Reproduccion", cancion.getEstado());
	}
	
	@Test
	void testSePonePlayLaCancionYSeGeneraUnErrorPorqueEstaEnModoDeReproduccion() throws IOException {
		cancion.play(song);
		
		assertThrows(Exception.class, () -> cancion.play(song));
		assertEquals("En Reproduccion", cancion.getEstado());
	}
	
	@Test
	void testSePonePlayLaCancionYSeGeneraUnErrorPorqueEstaEnModoPausada() throws IOException {
		cancion.play(song);
		cancion.pause();
		
		assertThrows(Exception.class, () -> cancion.play(song));
		assertEquals("En Pausa", cancion.getEstado());
	}
	
	@Test
	void testSePonePausaLaCancionYSeQuedaPausadaPorqueEstabaEnModoReproduccion() throws IOException {
		cancion.play(song);
		cancion.pause();
		
		assertEquals("En Pausa", cancion.getEstado());
	}
	
	@Test
	void testSePonePausaLaCancionYSeReproducePorqueEstabaEnModoPausada() throws IOException {
		cancion.play(song);
		cancion.pause();
		cancion.pause();
		
		assertEquals("En Reproduccion", cancion.getEstado());
	}
	
	@Test
	void testSePonePausaLaCancionYSeGeneraUnErrorPorqueEstabaEnModoDeSeleccion() {

		assertThrows(Exception.class, () -> cancion.pause());
		assertEquals("En Seleccion", cancion.getEstado());
	}
	
	@Test
	void testSePoneStopLaCancionEstandoEnModoReproduccionYSePasaAModoSeleccion() throws IOException {
        cancion.play(song);
		cancion.stop();
		
		assertEquals("En Seleccion", cancion.getEstado());
	}
	
	@Test
	void testSePoneStopLaCancionEstandoEnModoPausadaYSePasaAModoSeleccion() throws IOException {
		cancion.play(song);
		cancion.pause();
		cancion.stop();
		
		assertEquals("En Seleccion", cancion.getEstado());
	}
	
	@Test
	void testSePoneStopLaCancionEstandoEnModoSeleccionYNoPasaNada() {
         cancion.stop();
		
		assertEquals("En Seleccion", cancion.getEstado());
	}

}
