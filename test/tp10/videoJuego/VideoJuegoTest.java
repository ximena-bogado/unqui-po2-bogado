package tp10.videoJuego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VideoJuegoTest {

	private VideoJuego juego;
	
	@BeforeEach
	void testSetUp() {
		juego = new VideoJuego();
	}

	@Test
	void testNoSeRealizoNingunaOperacionYElEstadoDelJuegoEstaEnElInicio() {
		assertEquals(EstadoInicio.class, juego.getEstado());
	}
	
	@Test
	void testSeIngresaUnaFichaEnEstadoDeInicioYNoPasaNada() {
		juego.ingresarFicha();
		
		assertEquals(EstadoInicio.class, juego.getEstado());
	}
	
	@Test
	void testSeTocoElBotonDeInicioYElJuegoEstaEnEstadoDeIngresoDeFichas() {
		juego.botonInicio();
		
		assertEquals(EstadoIngresoDeFichas.class, juego.getEstado());
	}
	
	@Test
	void testSeTocoElBotonDeInicioEnEstadoDeIngresoDeFichasYElEstadoSigueIgual() {
		juego.botonInicio();
		juego.botonInicio();
		
		assertEquals(EstadoIngresoDeFichas.class, juego.getEstado());
	}
	
	@Test
	void testSeIngresoUnaFichaYElJuegoEstaEnEstadoDeIngresoDeUnaFicha() {
		juego.botonInicio();
		juego.ingresarFicha();
		
		assertEquals(EstadoUnaFicha.class, juego.getEstado());
	}
	
	@Test
	void testSeIngresoUnaFichaElBotonDeInicioYElJuegoEstaEnEstadoDeUnJugador() {
		juego.botonInicio();
		juego.ingresarFicha();
		juego.botonInicio();
		
		assertEquals(EstadoUnJugador.class, juego.getEstado());
	}

	
	@Test
	void testSeIngresoDosFichasYElJuegoEstaEnEstadoDeIngresoDeDosFichas() {
		juego.botonInicio();
		juego.ingresarFicha();
		juego.ingresarFicha();
		
		assertEquals(EstadoDosFichas.class, juego.getEstado());
	}
	
	@Test
	void testSeIngresoTresFichasYElEstadoDelJuegoSigueEnEstadoDeDosFichas() {
		juego.botonInicio();
		juego.ingresarFicha();
		juego.ingresarFicha();
		juego.ingresarFicha();
		
		assertEquals(EstadoDosFichas.class, juego.getEstado());
	}
	
	@Test
	void testSeIngresoDosFichasElBotonDeInicioYElJuegoEstaEnEstadoDeDosJugadores() {
		juego.botonInicio();
		juego.ingresarFicha();
		juego.ingresarFicha();
		juego.botonInicio();
		
		assertEquals(EstadoDosJugadores.class, juego.getEstado());
	}
	
	

}
