package tp10.reproductor;

import java.io.IOException;

public class Song {
	
	private Estado estado;
	
	

	public Song() {
		this.estado = new EstadoSeleccion();
	}

	public void play() throws IOException {
		estado.play(this);
		
	}

	public void pause() throws IOException {
		estado.pause(this);
		
	}

	public void stop() {
		estado.stop(this);
		
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
		
	}

	public Class<? extends Estado> getEstado() {
		
		return estado.getClass();
	}

}
