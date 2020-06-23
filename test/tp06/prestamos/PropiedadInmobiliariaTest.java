package tp06.prestamos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PropiedadInmobiliariaTest {

	@Test
	void testConstructor() {
		PropiedadInmobiliaria propiedad2 = new PropiedadInmobiliaria("terreno","alsina",6000);
		PropiedadInmobiliaria propiedad1 = new PropiedadInmobiliaria("departamento","otamendi",4000);
		
		assertEquals("departamento", propiedad1.getDescripcion());
		assertEquals("otamendi", propiedad1.getDireccion());
		assertEquals(4000, propiedad1.getValorFiscal());
		assertEquals("terreno", propiedad2.getDescripcion());
		assertEquals("alsina", propiedad2.getDireccion());
		assertEquals(6000, propiedad2.getValorFiscal());
	}

}
