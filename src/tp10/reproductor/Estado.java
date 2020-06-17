package tp10.reproductor;

import java.io.IOException;

public interface Estado {
	
	public void play(Song musica) throws IOException;
	
	public void pause(Song musica) throws IOException;
	
	public void stop(Song musica);

}
