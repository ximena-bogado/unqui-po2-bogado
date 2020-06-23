package tp09.concurso;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tp09.concurso.Participante;
import tp09.concurso.Servidor;

class ParticipanteTest {

	private Servidor servidor;
	private Participante jugador;

	@BeforeEach
	void testSetUp() {
		jugador = new Participante("Ximena");
		servidor = mock(Servidor.class);
	}
	
	@Test
	void testUnJugadorSolicitaUnirseAUnaPartida() {
		
		jugador.unirseAPartida(servidor);
		
		assertEquals(servidor, jugador.getServidor());
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
		jugador.comenzarPartida();
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
		jugador.comenzarPartida();
		jugador.finalizarPartida();
		jugador.enviarRespuesta("c");
		
		
		verify(servidor, never()).verificarRespuesta(jugador, "a", "c");;
	}
	
	@Test
	void testUnJugadorEnviaDosRespuestaAlJuegoDeDiferentesPreguntas() {
		
		jugador.unirseAPartida(servidor);
		jugador.comenzarPartida();
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
		jugador.comenzarPartida();
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
