package tp09.concurso;

import java.io.IOException;
import java.util.List;

public interface EstadoDePartida {

	void enviarRespuesta(Servidor servidor, Participante participante, List<String> preguntas, String respuesta) throws IOException;


}
