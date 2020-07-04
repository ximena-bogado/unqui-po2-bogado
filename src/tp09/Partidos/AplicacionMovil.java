package tp09.Partidos;

import java.util.ArrayList;
import java.util.List;

public class AplicacionMovil implements Suscriptor{

	private List<String> resultados;

	public AplicacionMovil() {
		this.resultados = new ArrayList<String>();
	}
	
	public List<String> getResultados() {
		return resultados;
	}

	@Override
	public void recibirInformacion(Partido partido) {
		resultados.add(partido.getResultado());
	}

	public void suscribirse(Aplicacion notificador, String interes) {
		notificador.agregar(this, interes);
		
	}

}
