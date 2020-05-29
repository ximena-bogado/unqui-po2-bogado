package tp9.concurso;

import java.io.IOException;
import java.util.List;

public class EstadoEnEspera implements EstadoDePartida {

	@Override
	public void enviarRespuesta(Servidor servidor, Participante participante, List<String> preguntas, String respuesta) throws IOException{
		System.out.println ("Accion incorrecta, la partida no comenzo");
	}



}
