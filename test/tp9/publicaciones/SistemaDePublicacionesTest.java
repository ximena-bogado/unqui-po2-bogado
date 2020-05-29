package tp9.publicaciones;


import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

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
