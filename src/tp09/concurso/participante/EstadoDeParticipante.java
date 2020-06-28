package tp09.concurso.participante;

import tp09.concurso.partida.Partida;

public interface EstadoDeParticipante {

	void recibirNotificacion(String notificacion, Participante participante);

	void enviarRespuesta(String respuesta, Partida servidor, Participante participante);

}
