package tp09.Partidos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PartidoTest {

	private Partido partido;

	@Test
	void testConstructor() {
		List<String> contrincantes = new ArrayList<>();
		
		partido = new Partido("Futbol",contrincantes , "3 a 1");
		
		assertEquals("Futbol", partido.getDeporte());
		assertEquals(contrincantes,partido.getContrincantes());
		assertEquals("3 a 1", partido.getResultado());
	}

}
