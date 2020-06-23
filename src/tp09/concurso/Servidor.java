package tp09.concurso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Servidor {

	private HashMap<Participante, Integer> participantes;
	private HashMap<String, String> preguntasYRespuestas;

	public Servidor(HashMap<String, String> preguntasYRespuestas) {
		this.participantes = new HashMap<Participante, Integer>();
		this.preguntasYRespuestas = preguntasYRespuestas;
	}

	public void agregarParticipante(Participante participante) {
		if (participantes.size() < 5) {
			this.participantes.put(participante, 0);
		}

	}

	public List<Participante> getParticipantes() {
		
		return new ArrayList<Participante>(participantes.keySet());
	}

	public void iniciarPartida() {
		for(Participante participante: participantes.keySet()) {
			participante.comenzarPartida();
			participante.recibirPreguntas(this.getPreguntas());
			notificar(participante, "Partida Iniciada");
		}
	}

	private void notificar(Participante participante, String notificacion) {
		participante.recibirNotificacion(notificacion);
		
	}

	public List<String> getPreguntas() {
		
		return new ArrayList<String>(preguntasYRespuestas.keySet());
	}

	public Integer puntajeDeParticipante(Participante participante) {
		
		return participantes.get(participante);
	}

	public void verificarRespuesta(Participante participante, String pregunta, String respuesta) {
		if (this.esRespuestaCorrecta(pregunta, respuesta)) {
			this.contabilizarPuntaje(participante);
			participante.recibirNotificacionDeRespuesta("Correcta");
			this.notificarATodos(participante.getNombre() + " " + "respondio correctamente la pregunta" + " " + pregunta);
			this.verificarSiJugadorGanoLaPartida(participante);
		}else {
			participante.recibirNotificacionDeRespuesta("Incorrecta");
		}	
	}

	private void verificarSiJugadorGanoLaPartida(Participante participante) {
		if ( participantes.get(participante) == this.getPreguntas().size()) {
			this.finalizarPartida(participante);
		}
		
	}

	private void finalizarPartida(Participante participanteGanador) {
		for(Participante participante: participantes.keySet()) {
			participante.finalizarPartida();
			notificar(participante, participanteGanador.getNombre() + " " + "gano la partida");
		}
		
	}

	private void contabilizarPuntaje(Participante participante) {
		Integer puntajeActual = participantes.get(participante);
		
		participantes.put(participante, puntajeActual + 1);
		
	}

	private boolean esRespuestaCorrecta(String pregunta, String respuesta) {
		String respuestaCorrecta = preguntasYRespuestas.get(pregunta);
		
		return respuestaCorrecta.equals(respuesta);
	}

	private void notificarATodos(String mensaje) {
		for(Participante participante: participantes.keySet()) {
			notificar(participante, mensaje);
		}
		
	}


}
