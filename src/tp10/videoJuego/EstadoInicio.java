package tp10.videoJuego;

public class EstadoInicio implements EstadoDelJuego {

	@Override
	public void botonInicio(VideoJuego juego) {
		juego.setEstado(new EstadoIngresoDeFichas());
		
	}

	@Override
	public void ingresarFicha(VideoJuego juego) {
		
	}


}
