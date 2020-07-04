package tp09.Partidos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotificadorTest {

	private Aplicacion notificador;

	@BeforeEach
	void testSetUp() {
		notificador = new Aplicacion();
	}
	
	@Test
	void testSeAgregaUnSuscriptorYLaCantidadDeSuscriptoresEsUno() {
		Suscriptor suscriptor = mock(Suscriptor.class);
		
		notificador.agregar(suscriptor, "Tenis");
		
		assertEquals(1,notificador.getSuscriptores().size());
	}
	
	@Test
	void testSeAgreganDosSuscricionesDelMismoSuscriptorYLaCantidadDeSuscriptoresEsUno() {
		Suscriptor suscriptor = mock(Suscriptor.class);
		
		notificador.agregar(suscriptor, "Tenis");
		notificador.agregar(suscriptor, "Nadal");
		
		assertEquals(1,notificador.getSuscriptores().size());
		assertEquals(2,notificador.getSuscripcion(suscriptor).size());
	}
	
	@Test
	void testSeNotificaAlServidorSuscriptoAlTenisYALaAplicacionMovil() {
		Suscriptor servidor = mock(Suscriptor.class);
		Suscriptor aplicacionMovil = mock(Suscriptor.class);
		Partido partido = mock(Partido.class);
		when(partido.getDeporte()).thenReturn("Tenis");
		
		notificador.agregar(servidor, "Tenis");
		notificador.agregar(aplicacionMovil, "Tenis");
		notificador.agregarPartido(partido);
		
		verify(servidor).recibirInformacion(partido);
		verify(aplicacionMovil).recibirInformacion(partido);
	}
	
	@Test
	void testSeNotificaAlServidorSuscriptoAlTenisYNoALaAplicacionMovilSuscriptaAlFutbol() {
		Suscriptor servidor = mock(Suscriptor.class);
		Suscriptor aplicacionMovil = mock(Suscriptor.class);
		Partido partido = mock(Partido.class);
		when(partido.getDeporte()).thenReturn("Tenis");
		
		notificador.agregar(servidor, "Tenis");
		notificador.agregar(aplicacionMovil, "Futbol");
		notificador.agregarPartido(partido);
		
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
		
		notificador.agregar(servidor, "Tenis");
		notificador.agregar(aplicacionMovil, "Nadal");
		notificador.agregarPartido(partido);
		
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
		
		notificador.agregar(servidor, "Tenis");
		notificador.agregar(aplicacionMovil, "Nadal");
		notificador.agregarPartido(partido);
		
		verify(servidor).recibirInformacion(partido);
		verify(aplicacionMovil, never()).recibirInformacion(partido);
	}

}
