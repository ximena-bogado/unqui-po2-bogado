package tp6.prestamos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ClienteTest {
	
	
	private Cliente cliente;
	private Banco banco;
	private SolicitudDeCredito solicitudPersonal;
	private SolicitudDeCredito solicitudHipotecario;


	@BeforeEach
	public void setUp() {
		this.cliente = new Cliente("Ximena","Bogado", "Otamendi", 24, 10000);
		this.banco = new Banco();
		this.solicitudPersonal = new SolicitudDeCreditoPersonal(cliente, 2000, 10);
		this.solicitudHipotecario = new SolicitudDeCreditoHipotecario(cliente, 4000, 5);

		
		
	}
	
	@Test
	void testConstructor() {
		assertEquals("Ximena",cliente.getNombre());
		assertEquals("Bogado",cliente.getApellido());
		assertEquals("Otamendi",cliente.getDireccion());
		assertEquals(24,cliente.getEdad());
		assertEquals(10000,cliente.getSueldoNetoMensual());
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
