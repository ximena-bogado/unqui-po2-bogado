package tp9.publicaciones;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArticuloTest {

	private Articulo articulo;

	@BeforeEach
	void testSetUp() {
		
	}
	
	@Test
	void testConstructor() {
		List<String> listaDeAutores = new ArrayList<String>();
		List<String> listaDeAfiliaciones = new ArrayList<String>();
		List<String> palabrasClaves = new ArrayList<String>();
		
		articulo = new Articulo("Smalltalk",listaDeAutores, listaDeAfiliaciones, "original", "OB", palabrasClaves);
		
		assertEquals("Smalltalk", articulo.getTitulo());
		assertEquals(listaDeAutores, articulo.getAutores());
		assertEquals(listaDeAfiliaciones, articulo.getFiliaciones());
		assertEquals("original", articulo.getTipo());
		assertEquals( "OB", articulo.getEditorial());
		assertEquals(palabrasClaves, articulo.getPalabrasClaves());
		
	}

}
