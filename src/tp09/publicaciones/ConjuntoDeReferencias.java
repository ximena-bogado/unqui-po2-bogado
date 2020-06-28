package tp09.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoDeReferencias implements IReferencia{

	private List<IReferencia> referencias;

	public ConjuntoDeReferencias() {
		referencias = new ArrayList<IReferencia>();
	}
	
	@Override
	public Boolean chequear(Articulo articulo) {
		Boolean resultado = true;
		for (IReferencia referencia: this.referencias) {
			resultado &= referencia.chequear(articulo);
		}
		return resultado;
	}

	public void agregarReferencia(IReferencia referencia) {
		this.referencias.add(referencia);
		
	}

	public List<IReferencia> getReferencias() {
		
		return referencias;
	}

}
