package tp6.prestamos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudTest {
	
	private SolicitudDeCredito solicitudPersonal;
	private SolicitudDeCredito solicitudHipotecario;
	private SolicitudDeCredito solicitudPersonalRechazada;
	private SolicitudDeCredito solicitudHipotecarioRechazada;
	private Cliente cliente;
	
	@BeforeEach
	public void setUp() {
		this.cliente = new Cliente("Ximena","Bogado", "Otamendi", 24, 10000);
		this.solicitudPersonal = new SolicitudDeCreditoPersonal(cliente, 2000, 10);
		this.solicitudHipotecario = new SolicitudDeCreditoHipotecario(cliente, 4000, 5);
		this.solicitudPersonalRechazada = new SolicitudDeCreditoPersonal(cliente, 2000, 10);
		this.solicitudHipotecarioRechazada = new SolicitudDeCreditoHipotecario(cliente, 4000, 5);

	}
	
	@Test
	void testConstructor() {
		assertEquals(cliente, solicitudPersonal.getCliente());
		assertEquals(2000, solicitudPersonal.getMontoSolicitado());
		assertEquals(10, solicitudPersonal.getCuotasMensuales());
	}
	
	@Test
	void testMontoCuotasMensuales() {
		assertEquals(2000, solicitudPersonal.getMontoDeCuotaMensual());
		assertEquals(800, solicitudPersonal.getMontoDeCuotaMensual());
	}
	

	@Test
	void testRealizarChequeo() {
		assertTrue(solicitudPersonal.realizarChequeo());
		assertTrue(solicitudHipotecario.realizarChequeo());
	}

}
