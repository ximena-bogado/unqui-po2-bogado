package tp09.Partidos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotificadorTest {

	private Notificador notificadorPorDeporte;
	private Notificador notificadorPorContrincante;

	@BeforeEach
	void testSetUp() {
		notificadorPorDeporte = new NotificadorPorDeporte();
		notificadorPorContrincante = new NotificadorPorContrincante();
	}
	
	@Test
	void testNoSeAgregaSuscriptoresYLaCantidadDeSuscriptoresEsCero() {
		
		
		List<Suscriptor> listaDeSuscriptores = notificadorPorDeporte.getSuscriptores();
		
		assertEquals(0,listaDeSuscriptores.size());
	}
	
	@Test
	void testSeAgregaUnSuscriptorYLaCantidadDeSuscriptoresEsUno() {
		Suscriptor suscriptor = mock(Suscriptor.class);
		
		notificadorPorDeporte.agregar(suscriptor);
		List<Suscriptor> listaDeSuscriptores = notificadorPorDeporte.getSuscriptores();
		
		assertEquals(1,listaDeSuscriptores.size());
	}
	
	@Test
	void testSeNotificaAlServidorSuscriptoAlTenisYALaAplicacionMovil() {
		Suscriptor servidor = mock(Suscriptor.class);
		Suscriptor aplicacionMovil = mock(Suscriptor.class);
		Partido partido = mock(Partido.class);
		when(partido.getDeporte()).thenReturn("Tenis");
		
		notificadorPorDeporte.agregar(servidor);
		notificadorPorDeporte.agregar(aplicacionMovil);
		List<String> suscripciones = new ArrayList<String>();
		suscripciones.add("Tenis");
		when(servidor.getSuscripciones()).thenReturn(suscripciones);
		when(aplicacionMovil.getSuscripciones()).thenReturn(suscripciones);
		notificadorPorDeporte.notificar(partido);
		
		verify(servidor).recibirInformacion(partido);
		verify(aplicacionMovil).recibirInformacion(partido);
	}
	
	@Test
	void testSeNotificaAlServidorSuscriptoAlTenisYNoALaAplicacionMovilSuscriptaAlFutbol() {
		Suscriptor servidor = mock(Suscriptor.class);
		Suscriptor aplicacionMovil = mock(Suscriptor.class);
		Partido partido = mock(Partido.class);
		when(partido.getDeporte()).thenReturn("Tenis");
		
		notificadorPorDeporte.agregar(servidor);
		notificadorPorDeporte.agregar(aplicacionMovil);
		List<String> suscripciones = new ArrayList<String>();
		suscripciones.add("Tenis");
		List<String> suscripciones2 = new ArrayList<String>();
		suscripciones2.add("Futbol");
		when(servidor.getSuscripciones()).thenReturn(suscripciones);
		when(aplicacionMovil.getSuscripciones()).thenReturn(suscripciones2);
		notificadorPorDeporte.notificar(partido);
		
		verify(servidor).recibirInformacion(partido);
		verify(aplicacionMovil, never()).recibirInformacion(partido);
	}
	
	@Test
	void testSeNotificaAlServidorSuscriptoAlTenisYALaAplicacionMovilSuscriptaAlContricanteNadal() {
		Suscriptor servidor = mock(Suscriptor.class);
		Suscriptor aplicacionMovil = mock(Suscriptor.class);
		Partido partido = mock(Partido.class);
		List<String> listaDeContrincantes = new ArrayList<String>();
		
		listaDeContrincantes.add("Nadal");
		when(partido.getDeporte()).thenReturn("Tenis");
		when(partido.getContrincantes()).thenReturn(listaDeContrincantes);
		
		notificadorPorDeporte.agregar(servidor);
		notificadorPorContrincante.agregar(aplicacionMovil);
		List<String> suscripciones = new ArrayList<String>();
		suscripciones.add("Tenis");
		List<String> suscripciones2 = new ArrayList<String>();
		suscripciones2.add("Nadal");
		when(servidor.getSuscripciones()).thenReturn(suscripciones);
		when(aplicacionMovil.getSuscripciones()).thenReturn(suscripciones2);
		notificadorPorDeporte.notificar(partido);
		notificadorPorContrincante.notificar(partido);
		
		verify(servidor).recibirInformacion(partido);
		verify(aplicacionMovil).recibirInformacion(partido);
	}
	
	@Test
	void testSeNotificaAlServidorSuscriptoAlTenisYNoALaAplicacionMovilSuscriptaAlContricanteNadal() {
		Suscriptor servidor = mock(Suscriptor.class);
		Suscriptor aplicacionMovil = mock(Suscriptor.class);
		Partido partido = mock(Partido.class);
		List<String> listaDeContrincantes = new ArrayList<String>();
		
		listaDeContrincantes.add("Roger");
		when(partido.getDeporte()).thenReturn("Tenis");
		when(partido.getContrincantes()).thenReturn(listaDeContrincantes);
		
		notificadorPorDeporte.agregar(servidor);
		notificadorPorContrincante.agregar(aplicacionMovil);
		List<String> suscripciones = new ArrayList<String>();
		suscripciones.add("Tenis");
		List<String> suscripciones2 = new ArrayList<String>();
		suscripciones2.add("Nadal");
		when(servidor.getSuscripciones()).thenReturn(suscripciones);
		when(aplicacionMovil.getSuscripciones()).thenReturn(suscripciones2);
		notificadorPorDeporte.notificar(partido);
		notificadorPorContrincante.notificar(partido);
		
		verify(servidor).recibirInformacion(partido);
		verify(aplicacionMovil, never()).recibirInformacion(partido);
	}

}
