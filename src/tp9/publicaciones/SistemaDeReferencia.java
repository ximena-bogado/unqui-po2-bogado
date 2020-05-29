package tp9.publicaciones;

import java.util.List;

public class SistemaDeReferencia {

	public List<Referencia> referencias;
	public Investigador investigador;

	public void agregarReferencias(List<Referencia> listaDeReferencias, Investigador investigador) {
		this.referencias = listaDeReferencias;
		this.investigador = investigador;
		
	}

	public void chequearArticulo(Articulo articulo) {
		if (this.chequearReferencias(articulo)) {
			investigador.recibirMensaje("Smalltalk");
		}
		
	}

	private Boolean chequearReferencias(Articulo articulo) {
		Boolean resultado = true;
		for (Referencia referencia: this.referencias) {
			resultado = resultado && referencia.chequear(articulo);
		}
		return resultado;
	}

	public List<Referencia> getReferencias() {
		
		return referencias;
	}

	public Investigador getInvestigador() {
		
		return investigador;
	}

}
