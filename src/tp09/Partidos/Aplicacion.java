package tp09.Partidos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Aplicacion {

	private Map<Suscriptor, Set<String>> suscripciones;
	private Set<Partido> partidos;
	

	public Aplicacion() {
		this.suscripciones = new HashMap<Suscriptor, Set<String>>();
		partidos = new HashSet<Partido>();
	}

    public Set<String> getSuscripcion(Suscriptor suscriptor) {
		
		return suscripciones.get(suscriptor);
	}
    
    public Set<Suscriptor> getSuscriptores() {
		
		return suscripciones.keySet();
	}
    
    public void agregarPartido(Partido partido) {
    	partidos.add(partido);
    	this.notificar(partido);
    }

	public void agregar(Suscriptor suscriptor, String interes) {
		if (suscripciones.containsKey(suscriptor)) {
			this.getSuscripcion(suscriptor).add(interes);
		}else {
			Set<String> listaDeSuscripcion = new HashSet<String>();
			listaDeSuscripcion.add(interes);
			suscripciones.put(suscriptor, listaDeSuscripcion);
		}
		
	}

	private void notificar(Partido partido) {
		for (Suscriptor suscriptor: this.getSuscriptores()) {
			this.chequearSuscripcion(suscriptor, partido);
			
		}
		
	}

	private void chequearSuscripcion(Suscriptor suscriptor, Partido partido) {
		if (this.chequearSuscripcionPorContricante(suscriptor, partido) | 
			this.chequearSuscripcionPorDeporte(suscriptor, partido)) {
			suscriptor.recibirInformacion(partido);
		}
		
	}

	private Boolean chequearSuscripcionPorContricante(Suscriptor suscriptor, Partido partido) {
		Set<String> suscripciones = this.getSuscripcion(suscriptor);
		List<String> contrincantes = partido.getContrincantes();
		Boolean resultado = false;
		for (String contrincante: contrincantes) {
			resultado |= this.chequearListaDeSuscripciones(suscripciones, contrincante);
		}
		return resultado;
	}
	
	
	private Boolean chequearSuscripcionPorDeporte(Suscriptor suscriptor, Partido partido) {
		return this.chequearListaDeSuscripciones(this.getSuscripcion(suscriptor), partido.getDeporte());
	}
	
	private Boolean chequearListaDeSuscripciones(Set<String> suscripciones2, String dato) {
		Boolean resultado = false;
		for (String suscripcion: suscripciones2) {
			resultado |= suscripcion.equals(dato);
		}
		return resultado;
	}

}
