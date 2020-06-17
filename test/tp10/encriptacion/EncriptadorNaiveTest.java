package tp10.encriptacion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EncriptadorNaiveTest {

	private EncriptadorNaive encriptador;
	private EstrategiaDeEncriptar estrategia;
	
	@BeforeEach
	void testSetUp() {
		encriptador = new EncriptadorNaive();
		
	}

	@Test
	void testElEncriptadorEncriptaUnMensajeYCambiaDeOrdenLasPalabras() {
		
		assertEquals("estas como hola", encriptador.encriptar("hola como estas"));
	}
	
	@Test
	void testElEncriptadorDesencriptaUnMensajeYCambiaDeOrdenLasPalabras() {
		
		assertEquals("hola como estas", encriptador.desencriptar("estas como hola"));
	}
	
	@Test
	void testElEncriptadorEncriptaUnMensajeYCambiaLasLetrasPorNumeros() {
		estrategia = new CambiarPorNumero();
		encriptador.asignar(estrategia);
		
		assertEquals( "4,9,5,7,15," , encriptador.encriptar("diego"));
	}
	
	@Test
	void testElEncriptadorDesencriptaUnMensajeYCambiaLasLetrasPorNumeros() {
		estrategia = new CambiarPorNumero();
		encriptador.asignar(estrategia);
		
		assertEquals("diego", encriptador.desencriptar("4,9,5,7,15,"));
	}
	
	@Test
	void testElEncriptadorEncriptaUnMensajeYCambiaLasVocalesPorLasVocalesSiguientes() {
		estrategia = new CambiarVocal();
		encriptador.asignar(estrategia);
		
		assertEquals( "hule cumu istes" , encriptador.encriptar("hola como estas"));
	}
	
	@Test
	void testElEncriptadorDesencriptaUnMensajeYCambiaLasVocalesPorLasVocalesAnteriores() {
		estrategia = new CambiarVocal();
		encriptador.asignar(estrategia);
		
		assertEquals("hola como estas", encriptador.desencriptar("hule cumu istes"));
	}

}
