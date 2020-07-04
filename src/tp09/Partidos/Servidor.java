package tp09.Partidos;

import java.util.HashSet;
import java.util.Set;

public class Servidor implements Suscriptor{

	private Set<Partido> partidos;


	public Servidor() {
		this.partidos = new HashSet<Partido>();
	}

	public Set<Partido> getPartidos() {
		return partidos;
	}

	@Override
	public void recibirInformacion(Partido partido) {
		partidos.add(partido);
	}

	public void suscribirse(Aplicacion notificador, String interes) {
	    notificador.agregar(this, interes);

	}

}
