package tp04.supermercado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp04.supermercado.ProductoPrimeraNecesidad;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoPrimeraNecesidadTest {

	private ProductoPrimeraNecesidad leche;
	private ProductoPrimeraNecesidad arroz;
	
	@BeforeEach
	public void setUp() {
		leche = new ProductoPrimeraNecesidad("Leche", 8d, false, 0.9d);
		arroz = new ProductoPrimeraNecesidad("arroz", 18.9d, false, 0.5d);
	}
	
	@Test
	public void testCalcularPrecio() {
		assertEquals(7.2d, leche.getPrecio());
		
		assertEquals(9.45d, arroz.getPrecio());
	}
}
