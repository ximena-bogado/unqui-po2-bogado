package tp9.Partidos;

import java.util.List;

public interface Suscriptor {

	void recibirInformacion(Partido partido);

	List<String> getSuscripciones();

}
