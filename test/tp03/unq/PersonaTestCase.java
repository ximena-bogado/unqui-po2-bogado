package tp03.unq;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaTestCase {
	
	private Persona persona1;
	private Persona persona2;
	private LocalDate fecha1;
	private LocalDate fecha2;

	@BeforeEach
	public void setUp() throws Exception {
		fecha1 = LocalDate.of(1995, Month.MAY, 31);
		fecha2 = LocalDate.of(1998, Month.AUGUST, 3);
		persona1 = new Persona("Ximena", fecha1);
		persona2= new Persona("Julian", fecha2);
		
	}
	
	@Test
	void testConstructor() {
		String nombrePersona1 = persona1.getNombre();
		assertEquals ("Ximena", nombrePersona1);
		String nombrePersona2 = persona2.getNombre();
		assertEquals ("Julian", nombrePersona2);
		
		LocalDate nacimientoPersona1 = persona1.getFechaDeNacimiento();
		assertEquals (fecha1, nacimientoPersona1);
		LocalDate nacimientoPersona2 = persona2.getFechaDeNacimiento();
		assertEquals (fecha2, nacimientoPersona2);
	}
	
	@Test
	void testCalcularEdad() {
		Integer edadDePersona1 = persona1.getEdad();
		assertEquals (25, edadDePersona1);
		
		Integer edadDePersona2 = persona2.getEdad();
		assertEquals (21, edadDePersona2);
	}
	
	@Test
	void testMenorQue() {
		assertTrue (persona2.menorQue(persona1));
		assertFalse (persona1.menorQue(persona2));
	}

}
