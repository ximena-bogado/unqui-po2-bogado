package tp9.concurso;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartidaTest {

	private Servidor servidor;
	private Participante participante1;
	private Participante participante2;
	private Participante participante3;
	private Participante participante4;
	private Participante participante5;
	
	@BeforeEach
	void testSetUp() {
		
		HashMap<String, String> preguntasYRespuestas = new HashMap<String, String>();
		preguntasYRespuestas.put("a", "c");
		preguntasYRespuestas.put("b", "d");
		
		participante1 = mock(Participante.class);
		participante2 = mock(Participante.class);
		participante3 = mock(Participante.class);
		participante4 = mock(Participante.class);
		participante5 = mock(Participante.class);
		
		servidor = new Servidor(preguntasYRespuestas);
	}

	@Test
	void testLaPartidaNoTieneParticipantes() {
		
		assertEquals(0, servidor.getParticipantes().size());
	}
	
	@Test
	void testLaPartidaTieneUnParticipante() {
		
		servidor.agregarParticipante(participante1);
		
		assertEquals(1, servidor.getParticipantes().size());
	}
	
	@Test
	void testLaPartidaSoloPuedeAgregarCincoParticipantes() {
		Participante participante6 = mock(Participante.class);;
		
		servidor.agregarParticipante(participante1);
		servidor.agregarParticipante(participante2);
		servidor.agregarParticipante(participante3);
		servidor.agregarParticipante(participante4);
		servidor.agregarParticipante(participante5);
		servidor.agregarParticipante(participante6);
		
		assertEquals(5, servidor.getParticipantes().size());
	}
	
	@Test
	void testComienzaLaPartidaSeNotificaATodosLosParticipantesYSeEntregaLaListaDePreguntas() {
		
		
		servidor.agregarParticipante(participante1);
		servidor.agregarParticipante(participante2);
		servidor.agregarParticipante(participante3);
		servidor.agregarParticipante(participante4);
		servidor.agregarParticipante(participante5);
		
		servidor.iniciarPartida();
		List<String> listaDePreguntas = servidor.getPreguntas();
		
		verify(participante1).recibirPreguntas(listaDePreguntas);
		verify(participante1).recibirNotificacion("Partida Iniciada");
		verify(participante1).comenzarPartida();
	}
	
	@Test
	void testElServidorRecibeUnaRespuestaDeUnJugadorYLaRespuestaEsCorrecta() {
		
		
		servidor.agregarParticipante(participante1);
		servidor.agregarParticipante(participante2);
		servidor.agregarParticipante(participante3);
		servidor.agregarParticipante(participante4);
		servidor.agregarParticipante(participante5);
		
		when(participante1.getNombre()).thenReturn("Ximena");
		servidor.iniciarPartida();
		servidor.verificarRespuesta(participante1, "a", "c");
		
		assertEquals(1, servidor.puntajeDeParticipante(participante1));
		verify(participante1).recibirNotificacionDeRespuesta("Correcta");
		verify(participante2).recibirNotificacion("Ximena respondio correctamente la pregunta a");
		verify(participante3).recibirNotificacion("Ximena respondio correctamente la pregunta a");
		verify(participante4).recibirNotificacion("Ximena respondio correctamente la pregunta a");
		verify(participante5).recibirNotificacion("Ximena respondio correctamente la pregunta a");
	}
	
	@Test
	void testElServidorRecibeUnaRespuestaDeUnJugadorYLaRespuestaEsIncorrecta() {
		
		
		servidor.agregarParticipante(participante1);
		servidor.agregarParticipante(participante2);
		servidor.agregarParticipante(participante3);
		servidor.agregarParticipante(participante4);
		servidor.agregarParticipante(participante5);
		
		when(participante1.getNombre()).thenReturn("Ximena");
		servidor.iniciarPartida();
		servidor.verificarRespuesta(participante1, "a", "h");
		
		assertEquals(0, servidor.puntajeDeParticipante(participante1));
		verify(participante1).recibirNotificacionDeRespuesta("Incorrecta");
	}
	
	@Test
	void testElServidorTieneUnGanadorYFinalizaLaPartida() {
		
		
		servidor.agregarParticipante(participante1);
		servidor.agregarParticipante(participante2);
		servidor.agregarParticipante(participante3);
		servidor.agregarParticipante(participante4);
		servidor.agregarParticipante(participante5);
		
		when(participante1.getNombre()).thenReturn("Ximena");
		servidor.iniciarPartida();
		servidor.verificarRespuesta(participante1, "a", "c");
		servidor.verificarRespuesta(participante1, "b", "d");
		
		assertEquals(2, servidor.puntajeDeParticipante(participante1));
		verify(participante1).finalizarPartida();
		verify(participante1).recibirNotificacion("Ximena gano la partida");
		verify(participante2).recibirNotificacion("Ximena gano la partida");
		verify(participante3).recibirNotificacion("Ximena gano la partida");
		verify(participante4).recibirNotificacion("Ximena gano la partida");
		verify(participante5).recibirNotificacion("Ximena gano la partida");
	}
	

}
