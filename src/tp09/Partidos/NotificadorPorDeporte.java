package tp09.Partidos;

public class NotificadorPorDeporte extends Notificador {
	
	protected void chequearSuscripcion(Suscriptor suscriptor, Partido partido) {
		if (super.chequearListaDeSuscripciones(suscriptor.getSuscripciones(), partido.getDeporte())) {
			suscriptor.recibirInformacion(partido);
		}
		
	}

}
