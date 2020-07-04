package tp10.reproductor;

import java.io.IOException;

public interface Estado {
	
	public void play(Song song, Reproductor musica) throws IOException;
	
	public void pause(Song musica, Reproductor reproductor) throws IOException;
	
	public void stop(Song musica, Reproductor reproductor);

	public String getEstado();

}
