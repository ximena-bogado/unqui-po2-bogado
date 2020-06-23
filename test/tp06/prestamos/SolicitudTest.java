package tp06.prestamos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolicitudTest {
	
	private SolicitudDeCredito solicitudPersonal;
	private SolicitudDeCreditoHipotecario solicitudHipotecario;
	private Cliente cliente;
	private Cliente cliente2;
	private PropiedadInmobiliaria garantia1;
	private PropiedadInmobiliaria garantia2;
	private Cliente cliente3;
	
	@BeforeEach
	public void setUp() {
		garantia1 = new PropiedadInmobiliaria("departamento","otamendi",8000);
		garantia2 = new PropiedadInmobiliaria("departamento","otamendi", 40);
		
		this.cliente = new Cliente("Ximena","Bogado", "Otamendi", 24, 10000d, garantia1);
		this.cliente2 = new Cliente("Ximena","Bogado", "Otamendi", 65, 1000d, garantia2);
		this.cliente3 = new Cliente("Ximena","Bogado", "Otamendi", 65, 1000d, garantia1);
		
		this.solicitudPersonal = new SolicitudDeCreditoPersonal(cliente, 2000d, 10);
		this.solicitudHipotecario = new SolicitudDeCreditoHipotecario(cliente, 4000d, 5);
		
	}
	
	@Test
	void testConstructor() {
		assertEquals(cliente, solicitudPersonal.getCliente());
		assertEquals(2000, solicitudPersonal.getMontoSolicitado());
		assertEquals(10, solicitudPersonal.getCuotasMensuales());
		assertEquals(garantia1, solicitudHipotecario.getGarantia());
	}
	
	@Test
	void testMontoCuotasMensuales() {
		assertEquals(200, solicitudPersonal.getMontoDeCuotaMensual());
		assertEquals(800, solicitudHipotecario.getMontoDeCuotaMensual());
	}
	

	@Test
	void testRealizarChequeoEnSolicitudesAceptadas() {
		assertTrue(solicitudPersonal.realizarChequeo());
		assertTrue(solicitudHipotecario.realizarChequeo());
	}
	
	@Test
	void testRealizarChequeoEnSolicitudesRechazadasPorMontoDeCuota() {
		SolicitudDeCredito solicitudPersonalRechazadaPorMontoDeCuota = new SolicitudDeCreditoPersonal(cliente3, 8000d, 1);
		SolicitudDeCredito solicitudHipotecarioRechazadaPorMontoDeCuota = new SolicitudDeCreditoHipotecario(cliente, 6000d, 1);
		
		assertFalse(solicitudPersonalRechazadaPorMontoDeCuota.realizarChequeo());
		assertFalse(solicitudHipotecarioRechazadaPorMontoDeCuota.realizarChequeo());
	}
	
	@Test
	void testRealizarChequeoEnSolicitudeHipotecariaRechazadaPorMontoTotal() {
		SolicitudDeCredito solicitudHipotecarioRechazadaPorMontoTotal = new SolicitudDeCreditoHipotecario(cliente2, 4000d, 5);
		
		assertFalse(solicitudHipotecarioRechazadaPorMontoTotal.realizarChequeo());
	}
	
	@Test
	void testRealizarChequeoEnSolicitudePersonalRechazadaPorIngresoAnual() {
		SolicitudDeCredito solicitudPersonalRechazadaPorIngresoAnual = new SolicitudDeCreditoPersonal(cliente2, 2000d, 10);
		
		assertFalse(solicitudPersonalRechazadaPorIngresoAnual.realizarChequeo());
	}
	
	@Test
	void testRealizarChequeoEnSolicitudeHipotecariaRechazadaPorSerMayorDe65AñosAlTerminarDePagar() {
		SolicitudDeCredito solicitudHipotecarioRechazadaPorMontoTotal = new SolicitudDeCreditoHipotecario(cliente3, 4000d, 15);
		
		assertFalse(solicitudHipotecarioRechazadaPorMontoTotal.realizarChequeo());
	}

}
