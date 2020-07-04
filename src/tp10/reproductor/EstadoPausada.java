package tp10.reproductor;

import java.io.IOException;

public class EstadoPausada implements Estado{

	@Override
	public void play(Song song, Reproductor musica) throws IOException {
		throw new IOException("accion incorrecta");
		
	}

	@Override
	public void pause(Song song, Reproductor musica) {
		song.pause();
		musica.setEstado(new EstadoEnReproduccion());
		
	}

	@Override
	public void stop(Song song, Reproductor musica) {
		song.stop();
		musica.setEstado(new EstadoSeleccion());
	}

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return "En Pausa";
	}

}
