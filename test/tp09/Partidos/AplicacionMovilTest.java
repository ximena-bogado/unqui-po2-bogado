package tp09.Partidos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AplicacionMovilTest {

	private AplicacionMovil aplicacion;
	private Aplicacion notificador;
	
	@BeforeEach
	public void setUp() {
		aplicacion = new AplicacionMovil();
		notificador = mock(Aplicacion.class);
	}

	@Test
	void testSeSuscribeAlDeporteTenis() {
		
		aplicacion.suscribirse(notificador, "Tenis");
		List<String> suscripciones = new ArrayList<String>();
		suscripciones.add("Tenis");
		
		verify(notificador).agregar(aplicacion, "Tenis");
	}
	
	@Test
	void testSeSuscribeAlDeporteTenisyAlContrincanteNadal() {
		aplicacion.suscribirse(notificador, "Tenis");
		aplicacion.suscribirse(notificador, "Nadal");
		List<String> suscripciones = new ArrayList<String>();
		suscripciones.add("Tenis");
		suscripciones.add("Nadal");
		
		verify(notificador).agregar(aplicacion, "Tenis");
		verify(notificador).agregar(aplicacion, "Nadal");
	}
	
	@Test
	void testRecibeElResultadoDeDosPartidosYLaCantidadDeResultadosEsDos() {
		Partido partido1 = mock(Partido.class);
		Partido partido2 = mock(Partido.class);
		
		aplicacion.recibirInformacion(partido1);
		aplicacion.recibirInformacion(partido2);
		
		assertEquals(2, aplicacion.getResultados().size());
	}

}
