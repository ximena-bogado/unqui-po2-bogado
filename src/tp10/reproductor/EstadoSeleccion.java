package tp10.reproductor;

import java.io.IOException;

public class EstadoSeleccion implements Estado{

	@Override
	public void play(Song musica) {
		musica.setEstado(new EstadoEnReproduccion());
		
	}

	@Override
	public void pause(Song musica) throws IOException {
		throw new IOException("accion incorrecta");
		
	}

	@Override
	public void stop(Song musica) {
		
		
	}

}
