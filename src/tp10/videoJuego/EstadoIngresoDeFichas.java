package tp10.videoJuego;

public class EstadoIngresoDeFichas implements EstadoDelJuego {


	@Override
	public void botonInicio(VideoJuego juego) {
		
	}

	@Override
	public void ingresarFicha(VideoJuego juego) {
		juego.setEstado(new EstadoUnaFicha());
		
	}


}
