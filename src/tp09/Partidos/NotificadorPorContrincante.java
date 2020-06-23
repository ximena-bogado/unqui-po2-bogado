package tp09.Partidos;

import java.util.List;

public class NotificadorPorContrincante extends Notificador{

	@Override
	protected void chequearSuscripcion(Suscriptor suscriptor, Partido partido) {
		List<String> suscripciones = suscriptor.getSuscripciones();
		List<String> contrincantes = partido.getContrincantes();
		if (this.chequearListaDeContrincantes(suscripciones, contrincantes)) {
			suscriptor.recibirInformacion(partido);
		}
		
	}

	private Boolean chequearListaDeContrincantes(List<String> suscripciones, List<String> contrincantes) {
		Boolean resultado = false;
		for (String contrincante: contrincantes) {
			resultado |= super.chequearListaDeSuscripciones(suscripciones, contrincante);
		}
		return resultado;
	}

}
