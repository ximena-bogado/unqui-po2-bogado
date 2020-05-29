package tp9.publicaciones;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
	void testInvestigadorSeSuscribeASistemaDeReferenciaConDosReferencias() {
		Referencia referencia1 = mock(Referencia.class);
		Referencia referencia2 = mock(Referencia.class);
		
		List<Referencia> listaDeReferencias = new ArrayList<Referencia>();
		listaDeReferencias.add(referencia1);
		listaDeReferencias.add(referencia2);
	
		SistemaDeReferencia sistemaDeReferencias = mock(SistemaDeReferencia.class);
		
		investigador.suscribirse(listaDeReferencias, sistemaDeReferencias);
		
		verify(sistemaDeReferencias).agregarReferencias(listaDeReferencias, investigador);
	}
	

}
