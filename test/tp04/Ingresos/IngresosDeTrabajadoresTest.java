package tp04.Ingresos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp04.Ingresos.Ingreso;
import tp04.Ingresos.IngresoPorHorasExtras;
import tp04.Ingresos.Trabajador;

class IngresosDeTrabajadoresTest {
	
	private Trabajador empleado;
	private Ingreso ingreso1;
	private IngresoPorHorasExtras ingresoPorHoras;

	@BeforeEach
	public void setUp() {
		empleado = new Trabajador();
		ingreso1 = new Ingreso(Month.MAY, "Hola", 1000);
		ingresoPorHoras = new IngresoPorHorasExtras(Month.MAY, "Hola", 1000, 4);
		
		empleado.addIngresoPercibido(ingreso1);
		empleado.addIngresoPercibido(ingresoPorHoras);
	}
	
	@Test
	public void testConstructor() {
		Double impuestoAPagar = empleado.getImpuestoAPagar();
		Integer montoImponible = empleado.getMontoImponible();
		Integer totalPercibido = empleado.getTotalPercibido();
		
		assertEquals(20,impuestoAPagar);
		assertEquals(1000,montoImponible);
		assertEquals(2000,totalPercibido);
		
	}

}
