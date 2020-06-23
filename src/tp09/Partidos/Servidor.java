package tp09.Partidos;

import java.util.ArrayList;
import java.util.List;

public class Servidor implements Suscriptor{

	private List<String> suscripciones;

	public Servidor() {
		this.suscripciones = new ArrayList<String>();
	}

	@Override
	public void recibirInformacion(Partido partido) {
		
	}

	@Override
	public List<String> getSuscripciones() {
		
		return suscripciones;
	}

	public void suscribirse(String info) {
	    this.suscripciones.add(info);
		;
	}

}
