package tp10.reproductor;

import java.io.IOException;

public class EstadoSeleccion implements Estado{

	@Override
	public void play(Song song, Reproductor musica) {
		musica.seleccionarCancion(song);
		song.play();
		musica.setEstado(new EstadoEnReproduccion());
		
	}

	@Override
	public void pause(Song song, Reproductor musica) throws IOException {
		throw new IOException("accion incorrecta");
		
	}

	@Override
	public void stop(Song song, Reproductor musica) {
		
	}

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return "En Seleccion";
	}

}
