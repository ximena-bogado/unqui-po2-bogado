package tp9.concurso;

import java.io.IOException;
import java.util.List;

public class EstadoIniciada implements EstadoDePartida{


	@Override
	public void enviarRespuesta(Servidor servidor, Participante participante, List<String> preguntas, String respuesta) throws IOException{
		servidor.verificarRespuesta(participante, preguntas.get(0), respuesta);
		
	}

}
