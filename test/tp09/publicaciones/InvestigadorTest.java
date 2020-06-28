package tp09.publicaciones;

import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InvestigadorTest {
	
	private Investigador investigador;
	private Articulo articulo;
	private SistemaDePublicaciones sistemaDePublicaciones;

	@BeforeEach
	void testSetUp() {
		investigador = new Investigador();
		articulo = mock(Articulo.class);
		sistemaDePublicaciones = mock(SistemaDePublicaciones.class);
	
	}

	@Test
	void testInvestigadorCargaUnArticuloEnSistemaDePublicaciones() {
		
		
		investigador.cargarArticulo(articulo, sistemaDePublicaciones);
		
		verify(sistemaDePublicaciones).agregarArticulo(articulo);
	}
	
	@Test
	void testInvestigadorSeSuscribeAUnSistemaDePublicacionesConUnaReferencia() {
		IReferencia referencia = mock(IReferencia.class);
		
		investigador.suscribirse(referencia, sistemaDePublicaciones);
		
		verify(sistemaDePublicaciones).agregarSuscriptor(investigador);
		
		assertEquals(1, investigador.getReferencias().size());
	}
	
	@Test
	void testInvestigadorRecibeUnArticuloYAhoraTiene1Articulo() {
		Articulo articulo = mock(Articulo.class);
		
		investigador.recibirArticulo(articulo);
		
		assertEquals(1, investigador.getArticulos().size());
	}
	

}
