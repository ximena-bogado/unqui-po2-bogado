package tp9.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class NotificadorDePublicaciones {

	private List<SistemaDeReferencia> listaDeSistemaDeReferencia;
	
	public NotificadorDePublicaciones() {
		this.listaDeSistemaDeReferencia = new ArrayList<SistemaDeReferencia>();
	}

	public void notificarPublicacion(Articulo articulo) {
		for(SistemaDeReferencia sistema: this.listaDeSistemaDeReferencia) {
			sistema.chequearArticulo(articulo);
		}
		
	}

	public void agregarSistemaDeReferencias(SistemaDeReferencia sistemaDeReferencia) {
		this.listaDeSistemaDeReferencia.add(sistemaDeReferencia);
		
	}

	public List<SistemaDeReferencia> getSistemaDeReferencias() {
		
		return this.listaDeSistemaDeReferencia;
	}

}
