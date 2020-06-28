package tp09.publicaciones;

import java.util.List;

public abstract class ReferenciaLista implements IReferencia{

	private String referencia;
	
	public ReferenciaLista(String referencia) {
		super();
		this.referencia = referencia;
	}

	@Override
	public Boolean chequear(Articulo articulo) {
		Boolean resultado = false;
		for(String nombre: this.getCampo(articulo)) {
			resultado |= this.chequearCampo(nombre);
		}
		
		return resultado;
	}
	
	private Boolean chequearCampo(String campo) {
		
		return campo.equals(referencia);
	}
	
	protected abstract List<String> getCampo(Articulo articulo);

}
