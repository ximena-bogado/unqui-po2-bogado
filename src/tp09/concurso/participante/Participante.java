package tp09.concurso.participante;

import java.util.List;

import tp09.concurso.partida.Partida;

public class Participante {


	private Partida servidor;
	private String nombre;
	private List<String> preguntas;
	private EstadoDeParticipante estado;

	public Participante(String nombre) {
		this.nombre = nombre;
		this.estado = new EstadoFueraDeJuego();
	}
	
	public void unirseAPartida(Partida servidor) {
		servidor.agregarParticipante(this);
		this.servidor = servidor;
	}

	public void recibirPreguntas(List<String> preguntas) {
		this.preguntas = preguntas;
		
	}

	public void recibirNotificacion(String notificacion) {
		this.estado.recibirNotificacion(notificacion, this);
		
	}

	public void recibirNotificacionDeRespuesta(String notificacion) {
		if (notificacion.equals("Correcta")) {
			preguntas.remove(0);
		}
	}

	public String getNombre() {
		
		return nombre;
	}

	public void enviarRespuesta(String respuesta){
		this.estado.enviarRespuesta(respuesta, servidor, this);
		
	}

	protected void setEstado(EstadoDeParticipante estado) {
		this.estado = estado;
		
	}

	public List<String> getPreguntas() {
		
		return preguntas;
	}

}
