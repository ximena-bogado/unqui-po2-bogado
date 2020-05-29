package tp9.publicaciones;

import java.util.List;

public class Investigador {

	public void cargarArticulo(Articulo articulo, SistemaDePublicaciones sistemaDePublicaciones) {
		sistemaDePublicaciones.agregarArticulo(articulo);
		
	}

	public void suscribirse(List<Referencia> listaDeReferencias, SistemaDeReferencia sistemaDeReferencias) {
		sistemaDeReferencias.agregarReferencias(listaDeReferencias, this);
		
	}

	public void recibirMensaje(String string) {
		// recibe el mensaje y hace lo que tenga que hacer
		
	}

}
