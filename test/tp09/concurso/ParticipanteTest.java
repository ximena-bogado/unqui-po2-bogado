package tp09.concurso;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp09.concurso.participante.Participante;
import tp09.concurso.partida.Partida;

class ParticipanteTest {

	private Partida servidor;
	private Participante jugador;

	@BeforeEach
	void testSetUp() {
		jugador = new Participante("Ximena");
		servidor = mock(Partida.class);
	}
	
	@Test
	void testConstructor() {
		
		assertEquals("Ximena", jugador.getNombre());
	}
	
	@Test
	void testUnJugadorSolicitaUnirseAUnaPartida() {
		
		jugador.unirseAPartida(servidor);
		
		verify(servidor).agregarParticipante(jugador);
	}
	
	@Test
	void testUnJugadorEnviaUnaRespuestaPeroElJuegoNoComenzo(){
		
		jugador.unirseAPartida(servidor);
		jugador.enviarRespuesta("c");
		
		
		verify(servidor, never()).verificarRespuesta(jugador, "a", "c");;
	}
	
	@Test
	void testUnJugadorEnviaUnaRespuestayElServidorlaVerifica() {
		
		jugador.unirseAPartida(servidor);
		jugador.recibirNotificacion("Partida Iniciada");
		List<String> preguntas = new ArrayList<String>();
		preguntas.add("a");
		preguntas.add("b");
		jugador.recibirPreguntas(preguntas);
		jugador.enviarRespuesta("c");
		
		verify(servidor).verificarRespuesta(jugador, "a", "c");
	}
	
	@Test
	void testUnJugadorEnviaUnaRespuestaPeroElJuegoYaFinalizo(){
		
		jugador.unirseAPartida(servidor);
		jugador.recibirNotificacion("Partida Iniciada");
		jugador.recibirNotificacion("ximena gano la partida");
		jugador.enviarRespuesta("c");
		
		
		verify(servidor, never()).verificarRespuesta(jugador, "a", "c");;
	}
	
	@Test
	void testUnJugadorEnviaDosRespuestaAlJuegoDeDiferentesPreguntas() {
		
		jugador.unirseAPartida(servidor);
		jugador.recibirNotificacion("Partida Iniciada");
		List<String> preguntas = new ArrayList<String>();
		preguntas.add("a");
		preguntas.add("b");
		jugador.recibirPreguntas(preguntas);
		jugador.enviarRespuesta("c");
		jugador.recibirNotificacionDeRespuesta("Correcta");
		jugador.enviarRespuesta("d");
		
		verify(servidor).verificarRespuesta(jugador, "a", "c");
		verify(servidor).verificarRespuesta(jugador, "b", "d");
	}
	
	@Test
	void testUnJugadorEnviaDosRespuestaAlJuegoDeLaMismaPregunta() {
		
		jugador.unirseAPartida(servidor);
		jugador.recibirNotificacion("Partida Iniciada");
		List<String> preguntas = new ArrayList<String>();
		preguntas.add("a");
		preguntas.add("b");
		jugador.recibirPreguntas(preguntas);
		jugador.enviarRespuesta("c");
		jugador.recibirNotificacionDeRespuesta("Incorrecta");
		jugador.enviarRespuesta("d");
		
		verify(servidor).verificarRespuesta(jugador, "a", "c");
		verify(servidor).verificarRespuesta(jugador, "a", "d");
	}

}
