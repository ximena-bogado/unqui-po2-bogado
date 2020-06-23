package tp09.publicaciones;


import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import tp09.publicaciones.Articulo;
import tp09.publicaciones.NotificadorDePublicaciones;
import tp09.publicaciones.SistemaDePublicaciones;

class SistemaDePublicacionesTest {

	private SistemaDePublicaciones sistemaDePublicacion;

	@Test
	void testSeAgregaUnArticuloYElNotificadorSeEntera() {
		Articulo articulo = mock(Articulo.class);
		NotificadorDePublicaciones notificadorDePublicaciones = mock(NotificadorDePublicaciones.class);
		sistemaDePublicacion = new SistemaDePublicaciones(notificadorDePublicaciones);
		
		sistemaDePublicacion.agregarArticulo(articulo);
		
		
		verify(notificadorDePublicaciones).notificarPublicacion(articulo);
	}

}
