package tp09.concurso.partida;


import java.util.List;

import tp09.concurso.participante.Participante;

public class EstadoEnEspera implements EstadoDePartida {


	@Override
	public void iniciarPartida(Partida servidor) {
		if (this.partidaListaParaComenzar(servidor)) {
			servidor.setEstado(new EstadoIniciada());
			this.enviarPreguntas(servidor.getParticipantes(), servidor.getPreguntas());
			servidor.notificarATodos("Partida Iniciada");
		}
	}

	private void enviarPreguntas(List<Participante> participantes, List<String> preguntas) {
		for(Participante participante: participantes) {
			participante.recibirPreguntas(preguntas);
		}
		
	}

	@Override
	public void verificarRespuesta(Participante participante, String pregunta, String respuesta, Partida servidor) {
		System.out.println ("Accion incorrecta, la partida no comenzo");
		
	}
	
	private boolean partidaListaParaComenzar(Partida servidor) {
		
		return servidor.getParticipantes().size() == 5 && servidor.getPreguntas().size() == 5;
	}

}
