package tp06.prestamos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BancoTest {

	private Banco banco;
	private Cliente cliente;
	private PropiedadInmobiliaria garantia;

	@BeforeEach
	public void setUp() {
		banco = new Banco();
		garantia = new PropiedadInmobiliaria("departamento","otamendi",4000);
		cliente = new Cliente("Ximena","Bogado", "Otamendi", 24, 10000d, garantia);
	}
	
	@Test
	void testBancoNoTieneRegistradoClientesYSuCantidadDeClientesEsCero() {
		assertEquals(0, banco.getClientes().size());
	}
	
	@Test
	void testBancoRegistraUnClienteYSuCantidadDeClientesEsUno() {
		banco.registrarCliente(cliente);
		
		assertEquals(1, banco.getClientes().size());
	}
	
	@Test
	void test_OtorgarPrestamos() {
		SolicitudDeCredito solicitudPersonal = new SolicitudDeCreditoPersonal(cliente, 2000d, 10);
		SolicitudDeCredito solicitudHipotecario = new SolicitudDeCreditoHipotecario(cliente, 4000d, 5);
		
		assertEquals(2000d, banco.otorgarPrestamo(solicitudPersonal));
		assertEquals(0d, banco.otorgarPrestamo(solicitudHipotecario));
	}

}
