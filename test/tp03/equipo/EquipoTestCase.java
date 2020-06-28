package tp03.equipo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquipoTestCase {

	private EquipoDeTrabajo equipoDeTrabajo;
	private Persona persona1;
	private Persona persona2;
	private Persona persona3;
	private Persona persona4;
	private Persona persona5;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		
		equipoDeTrabajo = new EquipoDeTrabajo("Bianca");
		persona1 = new Persona("Ximena","Bogado",24);
		persona2 = new Persona("Julian","Villarroel",21);
		persona3 = new Persona("Natalia","Bogado",28);
		persona4 = new Persona("Sergio","Bogado",30);
		persona5 = new Persona("Melisa","Bogado",31);
		
		equipoDeTrabajo.agregarAlEquipo(persona1);
		equipoDeTrabajo.agregarAlEquipo(persona2);
		equipoDeTrabajo.agregarAlEquipo(persona3);
		equipoDeTrabajo.agregarAlEquipo(persona4);
		equipoDeTrabajo.agregarAlEquipo(persona5);
	}
	
	@Test
	void testConstructor() {
		String nombre = equipoDeTrabajo.getNombre();
		assertEquals ("Bianca",nombre);
	}
	
	@Test
	void testPromedioDeEdad( ) {
		Integer promedioDeEdad = equipoDeTrabajo.promedioDeEdad();
		System.out.println(promedioDeEdad);
	}

}
