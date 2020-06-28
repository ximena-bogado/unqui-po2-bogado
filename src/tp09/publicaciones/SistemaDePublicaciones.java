package tp09.publicaciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SistemaDePublicaciones {

	private List<Articulo> articulos;
	private Set<Suscriptor> suscriptores;

	public SistemaDePublicaciones() {
		this.articulos = new ArrayList<Articulo>();
		this.suscriptores = new HashSet<Suscriptor>();
	}
	
	public void agregarSuscriptor(Suscriptor suscriptor) {
		suscriptores.add(suscriptor);
	}

	public void agregarArticulo(Articulo articulo) {
		articulos.add(articulo);
		this.notificarPublicacion(articulo);
		
	}
	
	private void notificarPublicacion(Articulo articulo) {
		for(Suscriptor suscriptor: this.suscriptores) {
			this.notificar(suscriptor, articulo);
		}
		
	}

	private void notificar(Suscriptor suscriptor, Articulo articulo) {
		if (this.chequearSuscripciones(suscriptor, articulo)) {
			suscriptor.recibirArticulo(articulo);
		}
		
	}

	private Boolean chequearSuscripciones(Suscriptor suscriptor, Articulo articulo) {
		Boolean resultado = false;
		for (IReferencia referencia: suscriptor.getReferencias()) {
			resultado |= referencia.chequear(articulo);
		}
		return resultado;
	}

}
