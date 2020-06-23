package tp09.concurso;

import java.io.IOException;
import java.util.List;

public class EstadoFinalizada implements EstadoDePartida{



	@Override
	public void enviarRespuesta(Servidor servidor, Participante participante, List<String> preguntas, String respuesta) throws IOException{
		throw new IOException("Accion incorrecta, la partida ya finalizo");
		
	}}
