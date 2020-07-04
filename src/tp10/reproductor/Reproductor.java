package tp10.reproductor;

import java.io.IOException;

public class Reproductor {
	
	private Estado estado;
	private Song cancion;
	
	

	public Reproductor() {
		this.estado = new EstadoSeleccion();
	}

	public void play(Song song) throws IOException {
		estado.play(song, this);
		
	}

	public void pause() throws IOException {
		estado.pause(cancion, this);
		
	}

	public void stop() {
		estado.stop(cancion, this);
		
	}

	protected void setEstado(Estado estado) {
		this.estado = estado;
		
	}

	public String getEstado() {
		
		return estado.getEstado();
	}

	public void seleccionarCancion(Song song) {
		cancion = song;
		
	}

}
