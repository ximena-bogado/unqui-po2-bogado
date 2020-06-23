package tp09.publicaciones;

public class ReferenciaAutor extends Referencia {

	public ReferenciaAutor(String referencia) {
		super(referencia);
	}

	public Boolean chequear(Articulo articulo) {
		Boolean resultado = false;
		for(String autor: articulo.getAutores()) {
			resultado |= this.chequearCampo(autor);
		}
		
		return resultado;
	}

	@Override
	protected String getCampo(Articulo articulo) {
		
		return null;
	}

}
