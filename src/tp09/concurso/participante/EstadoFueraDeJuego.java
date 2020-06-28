package tp09.concurso.participante;

import tp09.concurso.partida.Partida;

public class EstadoFueraDeJuego implements EstadoDeParticipante {

	@Override
	public void recibirNotificacion(String notificacion, Participante participante) {
		if (notificacion == "Partida Iniciada") {
			participante.setEstado(new EstadoEnJuego());
		}
	}

	@Override
	public void enviarRespuesta(String respuesta, Partida servidor, Participante participante) {
		System.out.println ("Accion incorrecta, la partida no comenzo");
	}


}
