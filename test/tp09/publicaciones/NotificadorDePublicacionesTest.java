package tp09.publicaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp09.publicaciones.Articulo;
import tp09.publicaciones.NotificadorDePublicaciones;
import tp09.publicaciones.SistemaDeReferencia;

class NotificadorDePublicacionesTest {

	private NotificadorDePublicaciones notificador;

	@BeforeEach
	void testSetUp() {
		notificador = new NotificadorDePublicaciones();
	}
	
	@Test
	void testElNotificadorNoTieneUnSistemaDeReferenciaAgregado() {
		
		List<SistemaDeReferencia> listaDeReferencias = notificador.getSistemaDeReferencias();
		
		assertEquals(0,listaDeReferencias.size());
	}
	
	@Test
	void testSeAgregaUnSistemaDeReferenciasAlNotificadorDePublicaciones() {
		
		SistemaDeReferencia sistemaDeReferencia = mock(SistemaDeReferencia.class);
		
		notificador.agregarSistemaDeReferencias(sistemaDeReferencia);
		List<SistemaDeReferencia> listaDeReferencias = notificador.getSistemaDeReferencias();
		
		assertEquals(1,listaDeReferencias.size());
	}
	
	@Test
	void testSeNotificaAlSistemaDeReferenciaQueSeAgregoUnArticulo() {
        SistemaDeReferencia sistemaDeReferencia = mock(SistemaDeReferencia.class);
        SistemaDeReferencia sistemaDeReferencia2 = mock(SistemaDeReferencia.class);
        Articulo articulo = mock(Articulo.class);
		
		notificador.agregarSistemaDeReferencias(sistemaDeReferencia);
		notificador.agregarSistemaDeReferencias(sistemaDeReferencia2);
		
		notificador.notificarPublicacion(articulo);
		
		verify(sistemaDeReferencia).chequearArticulo(articulo);
		verify(sistemaDeReferencia2).chequearArticulo(articulo);
		
	}

}
