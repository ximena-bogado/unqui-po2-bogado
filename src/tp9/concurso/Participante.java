package tp9.concurso;

import java.util.List;

public class Participante {


	private Servidor servidor;
	private EstadoDePartida estado;
	private String nombre;
	private List<String> preguntas;

	public Participante(String nombre) {
		this.nombre = nombre;
		this.estado = new EstadoEnEspera();
	}

	public void recibirPreguntas(List<String> preguntas) {
		this.preguntas = preguntas;
		
	}

	public void recibirNotificacion(String notificacion) {
		// TODO Auto-generated method stub
		
	}


	public void recibirNotificacionDeRespuesta(String notificacion) {
		if (notificacion.equals("Correcta")) {
			preguntas.remove(0);
		}
	}

	public List<String> getPreguntas() {
		return preguntas;
	}

	public String getNombre() {
		
		return nombre;
	}

	public void finalizarPartida() {
		estado = new EstadoFinalizada();
		
	}

	public void comenzarPartida() {
		estado = new EstadoIniciada();
		
	}

	public void unirseAPartida(Servidor servidor) {
		servidor.agregarParticipante(this);
		this.servidor = servidor;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void enviarRespuesta(String respuesta){
		try {
			this.estado.enviarRespuesta(servidor, this, preguntas, respuesta);
		}catch (Exception mensaje) {
			System.out.println(mensaje);
		}
		
		
	}


}
