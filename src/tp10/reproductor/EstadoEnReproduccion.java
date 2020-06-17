package tp10.reproductor;

import java.io.IOException;

public class EstadoEnReproduccion implements Estado{

	@Override
	public void play(Song musica) throws IOException {
		throw new IOException("accion incorrecta");
		
	}

	@Override
	public void pause(Song musica) {
		musica.setEstado(new EstadoPausada());
		
	}

	@Override
	public void stop(Song musica) {
		musica.setEstado(new EstadoSeleccion());
		
	}

}