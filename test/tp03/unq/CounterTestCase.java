package tp03.unq;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp03.unq.Counter;
import tp03.unq.MultiOperador;

class CounterTestCase {
	
	private Counter counter;
	private MultiOperador multioperador;
	

	@BeforeEach
	public void setUp() throws Exception {
		counter = new Counter();
		multioperador = new MultiOperador();
		
		
		counter.addNumber(1);
		counter.addNumber(3);
		counter.addNumber(5);
		counter.addNumber(7);
		counter.addNumber(9);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(4);
	}
	
	@Test
	public void testConstructor() {
		Integer cantidadDePares = counter.cantidadDePares();
		assertEquals (1,cantidadDePares);
		Integer cantidadDeImpares = counter.cantidadDeImpares();
		assertEquals (9,cantidadDeImpares);
		Integer cantidadDeMultiplosDeDos = counter.cantidadDeMultiplosDe(2);
		assertEquals (1,cantidadDeMultiplosDeDos);
	}

	
	@Test
	public void testAddNumber() {
		counter.addNumber(1);
		counter.addNumber(2);
		Integer cantidadDeImpares = counter.cantidadDeImpares();
		assertEquals (10,cantidadDeImpares);
		Integer cantidadDePares = counter.cantidadDePares();
		assertEquals (2,cantidadDePares);
		Integer cantidadDeMultiplosDeDos = counter.cantidadDeMultiplosDe(2);
		assertEquals (2,cantidadDeMultiplosDeDos);
		
	}
	
	@Test
	public void testTiposPrimitivos(){
        System.out.println(counter.getNumeroSinDefinir());
        Integer numeroSinDefinir = null;
        System.out.println(numeroSinDefinir);
		
	}
	
	@Test
	public void testMultioperador(){
        Integer suma = multioperador.sumarTodo(counter.getContador());
        Integer resta = multioperador.restarTodo(counter.getContador());
        Integer multiplicacion = multioperador.multiplicarTodo(counter.getContador());
        assertEquals (33,suma);
        assertEquals (-31,resta);
        assertEquals (3780,multiplicacion);
	}
	
	
	
}
