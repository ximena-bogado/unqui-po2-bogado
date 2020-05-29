package tp9.publicaciones;

public class SistemaDePublicaciones {

	private NotificadorDePublicaciones notificador;

	public SistemaDePublicaciones(NotificadorDePublicaciones notificadorDePublicaciones) {
		this.notificador = notificadorDePublicaciones;
	}

	public void agregarArticulo(Articulo articulo) {
		//agrega un articulo pero no es importante para este ejercicio, solo la notificacion
		notificador.notificarPublicacion(articulo);
		
	}

}
