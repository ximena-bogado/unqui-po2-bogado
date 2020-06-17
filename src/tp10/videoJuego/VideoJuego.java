package tp10.videoJuego;

public class VideoJuego {
	
	private EstadoDelJuego estado;

	public VideoJuego() {
		this.estado = new EstadoInicio();
	}

	public void botonInicio() {
		estado.botonInicio(this);
	}
	
	public void ingresarFicha() {
		estado.ingresarFicha(this);;
	}

	public void setEstado(EstadoDelJuego estado) {
		this.estado = estado;
		
	}

	public Class<? extends EstadoDelJuego> getEstado() {
		return estado.getClass();
	}

}
