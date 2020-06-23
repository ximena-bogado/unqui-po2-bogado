package tp09.Partidos;

import java.util.ArrayList;
import java.util.List;

public abstract class Notificador {

	private List<Suscriptor> suscriptores;
	

	public Notificador() {
		this.suscriptores = new ArrayList<Suscriptor>();
	}

	public List<Suscriptor> getSuscriptores() {
		
		return suscriptores;
	}

	public void agregar(Suscriptor suscriptor) {
		
		suscriptores.add(suscriptor);
		
	}

	public void notificar(Partido partido) {
		for (Suscriptor suscriptor: this.suscriptores) {
			this.chequearSuscripcion(suscriptor, partido);
			
		}
		
	}

	protected abstract void chequearSuscripcion(Suscriptor suscriptor, Partido partido);
	
	protected Boolean chequearListaDeSuscripciones(List<String> suscripciones, String dato) {
		Boolean resultado = false;
		for (String suscripcion: suscripciones) {
			resultado |= suscripcion.equals(dato);
		}
		return resultado;
	}

}
