package tp10.videoJuego;

public class EstadoDosFichas implements EstadoDelJuego {

	@Override
	public void botonInicio(VideoJuego juego) {
		juego.setEstado(new EstadoDosJugadores());

	}

	@Override
	public void ingresarFicha(VideoJuego juego) {
		// TODO Auto-generated method stub

	}

}
