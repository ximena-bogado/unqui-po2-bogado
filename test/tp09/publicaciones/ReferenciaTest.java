package tp09.publicaciones;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import tp09.publicaciones.Articulo;
import tp09.publicaciones.Referencia;
import tp09.publicaciones.ReferenciaAutor;
import tp09.publicaciones.ReferenciaEditorial;
import tp09.publicaciones.ReferenciaFiliaciones;
import tp09.publicaciones.ReferenciaPalabraClave;
import tp09.publicaciones.ReferenciaTipo;
import tp09.publicaciones.ReferenciaTitulo;

class ReferenciaTest {

	private Referencia referencia;

	@Test
	void testVerificarTituloDaTrue() {
		referencia = new ReferenciaTitulo("Smalltalk");
		Articulo articulo = mock(Articulo.class);
		
		when(articulo.getTitulo()).thenReturn("Smalltalk");
		
		assertTrue(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarTituloDaFalse() {
		referencia = new ReferenciaTitulo("Java");
		Articulo articulo = mock(Articulo.class);
		
		when(articulo.getTitulo()).thenReturn("Smalltalk");
		
		assertFalse(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarAutorDaTrue() {
		referencia = new ReferenciaAutor("Gamma");
		Articulo articulo = mock(Articulo.class);
		List<String> listaDeAutores = new ArrayList<String>();
		listaDeAutores.add("Gamma");
		
		when(articulo.getAutores()).thenReturn(listaDeAutores);
		
		assertTrue(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarAutorDaFalse() {
		referencia = new ReferenciaAutor("Helm");
		Articulo articulo = mock(Articulo.class);
		List<String> listaDeAutores = new ArrayList<String>();
		listaDeAutores.add("Gamma");
		
		when(articulo.getAutores()).thenReturn(listaDeAutores);
		
		assertFalse(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarFiliacionesDaTrue() {
		referencia = new ReferenciaFiliaciones("Universidad");
		Articulo articulo = mock(Articulo.class);
		List<String> listaDeFiliaciones = new ArrayList<String>();
		listaDeFiliaciones.add("Universidad");
		
		when(articulo.getFiliaciones()).thenReturn(listaDeFiliaciones);
		
		assertTrue(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarFiliacionesDaFalse() {
		referencia = new ReferenciaFiliaciones("Laboratorio");
		Articulo articulo = mock(Articulo.class);
		List<String> listaDeFiliaciones = new ArrayList<String>();
		listaDeFiliaciones.add("Universidad");
		
		when(articulo.getAutores()).thenReturn(listaDeFiliaciones);
		
		assertFalse(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarPalabraClaveDaTrue() {
		referencia = new ReferenciaPalabraClave("Programacion");
		Articulo articulo = mock(Articulo.class);
		List<String> palabrasClaves = new ArrayList<String>();
		palabrasClaves.add("Programacion");
		
		when(articulo.getPalabrasClaves()).thenReturn(palabrasClaves);
		
		assertTrue(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarPalabraClaveDaFalse() {
		referencia = new ReferenciaPalabraClave("Objetos");
		Articulo articulo = mock(Articulo.class);
		List<String> palabrasClaves = new ArrayList<String>();
		palabrasClaves.add("Programacion");
		
		when(articulo.getPalabrasClaves()).thenReturn(palabrasClaves);
		
		assertFalse(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarEditorialDaTrue() {
		referencia = new ReferenciaEditorial("Bo");
		Articulo articulo = mock(Articulo.class);
		
		when(articulo.getEditorial()).thenReturn("Bo");
		
		assertTrue(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarEditorialDaFalse() {
		referencia = new ReferenciaEditorial("JM");
		Articulo articulo = mock(Articulo.class);
		
		when(articulo.getEditorial()).thenReturn("Bo");
		
		assertFalse(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarTipoDaTrue() {
		referencia = new ReferenciaTipo("general");
		Articulo articulo = mock(Articulo.class);
		
		when(articulo.getTipo()).thenReturn("general");
		
		assertTrue(referencia.chequear(articulo));
	}
	
	@Test
	void testVerificarTipoDaFalse() {
		referencia = new ReferenciaTipo("informatico");
		Articulo articulo = mock(Articulo.class);
		
		when(articulo.getTipo()).thenReturn("general");
		
		assertFalse(referencia.chequear(articulo));
	}

}
