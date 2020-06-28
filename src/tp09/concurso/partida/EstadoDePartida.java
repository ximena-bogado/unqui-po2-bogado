package tp09.concurso.partida;

import tp09.concurso.participante.Participante;

public interface EstadoDePartida {

	void iniciarPartida(Partida servidor);

	void verificarRespuesta(Participante participante, String pregunta, String respuesta, Partida servidor);

}
