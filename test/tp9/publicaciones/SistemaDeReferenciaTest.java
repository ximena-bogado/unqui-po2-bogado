package tp9.publicaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaDeReferenciaTest {

	private SistemaDeReferencia sistemaDeReferencias;

	@BeforeEach
	void testSetUp() {
		sistemaDeReferencias = new SistemaDeReferencia();
	}
	
	@Test
	void testSeAgregaUnaListaDeReferenciasDeUnInvestigadorAlSistemaDeReferencias() {
		List<Referencia> listaDeReferencias = new ArrayList<Referencia>();
		Investigador investigador = mock(Investigador.class);
		
		sistemaDeReferencias.agregarReferencias(listaDeReferencias, investigador);
		
		assertEquals(listaDeReferencias, sistemaDeReferencias.getReferencias());
		assertEquals(investigador, sistemaDeReferencias.getInvestigador());
	}
	
	@Test
	void testSeChequeaUnArticuloYSeNotificaAlInvestigador() {
		Referencia referencia = mock(Referencia.class);
		List<Referencia> listaDeReferencias = new ArrayList<Referencia>();
		listaDeReferencias.add(referencia);
		Investigador investigador = mock(Investigador.class);
		Articulo articulo = mock(Articulo.class);
		
		when(articulo.getTitulo()).thenReturn("Smalltalk");
		when(referencia.chequear(articulo)).thenReturn(true);
		
		sistemaDeReferencias.agregarReferencias(listaDeReferencias, investigador);
		sistemaDeReferencias.chequearArticulo(articulo );
		
		verify(investigador).recibirMensaje("Smalltalk");
		
	}
	
	@Test
	void testSeChequeaUnArticuloYNoSeNotificaAlInvestigador() {
		Referencia referencia = mock(Referencia.class);
		List<Referencia> listaDeReferencias = new ArrayList<Referencia>();
		listaDeReferencias.add(referencia);
		Investigador investigador = mock(Investigador.class);
		Articulo articulo = mock(Articulo.class);
		
		when(referencia.chequear(articulo)).thenReturn(false);
		
		sistemaDeReferencias.agregarReferencias(listaDeReferencias, investigador);
		sistemaDeReferencias.chequearArticulo(articulo );
		
		verifyZeroInteractions(investigador);
		
	}

}
