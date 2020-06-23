package tp05.mascota;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp03.unq.Persona;
import tp05.mascota.Mascota;
import tp05.mascota.SerVivo;

class GetNombreTest {

	private Mascota mascota1;
	private Mascota mascota2;
	private Persona persona1;
	private Persona persona2;
	private ArrayList<SerVivo> lista;
	private LocalDate fecha1;
	private LocalDate fecha2;

	@BeforeEach
	public void setUp() {
		fecha1 = LocalDate.of(1995, Month.MAY, 31);
		fecha2 = LocalDate.of(1998, Month.AUGUST, 3);
		mascota1 = new Mascota("bianca", "sharpei");
		mascota2 = new Mascota("samy", "sharpei");
		persona1 = new Persona("ximena", fecha1);
		persona2 = new Persona("Julian", fecha2);
		lista = new ArrayList<SerVivo>();
		
		lista.add(mascota1);
		lista.add(mascota2);
		lista.add(persona1);
		lista.add(persona2);
		
	}
	
	@Test
	void testRegistrarproducto() {
		
		for (SerVivo serVivo: lista) {
			
			System.out.println(serVivo.getNombre());
		}
		
	}

}
