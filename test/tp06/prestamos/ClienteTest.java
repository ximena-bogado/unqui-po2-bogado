package tp06.prestamos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ClienteTest {
	
	
	private Cliente cliente;
	private Banco banco;
	private SolicitudDeCredito solicitudPersonal;
	private SolicitudDeCredito solicitudHipotecario;
	private PropiedadInmobiliaria garantia;


	@BeforeEach
	public void setUp() {
		garantia = new PropiedadInmobiliaria("departamento","otamendi",4000);
		
		this.cliente = new Cliente("Ximena","Bogado", "Otamendi", 24, 10000d, garantia);
		this.banco = new Banco();
		this.solicitudPersonal = new SolicitudDeCreditoPersonal(cliente, 2000d, 10);
		this.solicitudHipotecario = new SolicitudDeCreditoHipotecario(cliente, 4000d, 5);

		
		
	}
	
	@Test
	void testConstructor() {
		assertEquals("Ximena",cliente.getNombre());
		assertEquals("Bogado",cliente.getApellido());
		assertEquals("Otamendi",cliente.getDireccion());
		assertEquals(24,cliente.getEdad());
		assertEquals(10000,cliente.getSueldoNetoMensual());
		assertEquals(garantia,cliente.getPropiedadInmobiliaria());
	}	
	
	@Test
	void testSueldoNetoAnual() {
		
		assertEquals(120000,cliente.getSueldoNetoAnual());
	}
	
	@Test
	void testPedirPrestamo() {
		cliente.solicitarPrestamo(banco, solicitudPersonal);
		
		assertEquals(2000,banco.montoTotalDeDineroADesembolsar());
		
		cliente.solicitarPrestamo(banco, solicitudHipotecario);
		
		assertEquals(6000,banco.montoTotalDeDineroADesembolsar());
		
	}

}
