package tp9.Partidos;

import java.util.ArrayList;
import java.util.List;

public class AplicacionMovil implements Suscriptor{

	private List<String> suscripciones;

	public AplicacionMovil() {
		this.suscripciones = new ArrayList<String>();
	}

	@Override
	public void recibirInformacion(Partido partido) {
		
		
	}

	@Override
	public List<String> getSuscripciones() {
		
		return suscripciones;
	}

	public void suscribirse(String suscripcion) {
		this.suscripciones.add(suscripcion);
		
	}

}
