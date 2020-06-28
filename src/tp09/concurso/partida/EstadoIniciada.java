package tp09.concurso.partida;

import tp09.concurso.participante.Participante;

public class EstadoIniciada implements EstadoDePartida{


	@Override
	public void iniciarPartida(Partida servidor) {
		
		System.out.println ("Accion incorrecta, la partida ya comenzo");
	}
	
	public void verificarRespuesta(Participante participante, String pregunta, String respuesta, Partida servidor) {
		if (servidor.esRespuestaCorrecta(pregunta, respuesta)) {
			servidor.contabilizarPuntaje(participante);
			participante.recibirNotificacionDeRespuesta("Correcta");
			servidor.notificarATodos(participante.getNombre() + " " + "respondio correctamente la pregunta" + " " + pregunta);
			this.verificarSiJugadorGanoLaPartida(participante, servidor);
		}else {
			participante.recibirNotificacionDeRespuesta("Incorrecta");
		}	
	}
	
	private void verificarSiJugadorGanoLaPartida(Participante participante, Partida servidor) {
		if ( servidor.puntajeDeParticipante(participante) == 5) {
			servidor.notificarATodos(participante.getNombre() + " " + "gano la partida");
			servidor.setEstado(new EstadoEnEspera());
		}
	}

}
