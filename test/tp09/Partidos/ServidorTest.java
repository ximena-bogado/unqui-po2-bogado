package tp09.Partidos;

import static org.junit.jupiter.api.Assertions.*;


import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServidorTest {

	private Servidor servidor;
	private Aplicacion notificador;
	
	@BeforeEach
	public void setUp() {
		servidor = new Servidor();
		notificador = mock(Aplicacion.class);
	}

	@Test
	void testSeSuscribeAlDeporteTenis() {

		servidor.suscribirse(notificador, "Tenis");
		
		verify(notificador).agregar(servidor, "Tenis");
	}
	
	@Test
	void testSeSuscribeAlDeporteTenisyFutbol() {
		servidor = new Servidor();
		servidor.suscribirse(notificador, "Tenis");
		servidor.suscribirse(notificador, "Futbol");
		
		verify(notificador).agregar(servidor, "Tenis");
		verify(notificador).agregar(servidor, "Futbol");
	}
	
	@Test
	void testRecibeElResultadoDeDosPartidosYLaCantidadDeResultadosEsDos() {
		Partido partido1 = mock(Partido.class);
		Partido partido2 = mock(Partido.class);
		
		servidor.recibirInformacion(partido1);
		servidor.recibirInformacion(partido2);
		
		assertEquals(2, servidor.getPartidos().size());
	}

}
