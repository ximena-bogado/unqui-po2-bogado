package tp09.publicaciones;

public class ReferenciaFiliaciones extends Referencia {

	public ReferenciaFiliaciones(String referencia) {
		super(referencia);
		// TODO Auto-generated constructor stub
	}
	
	public Boolean chequear(Articulo articulo) {
		Boolean resultado = false;
		for(String filiacion: articulo.getFiliaciones()) {
			resultado |= this.chequearCampo(filiacion);
		}
		
		return resultado;
	}

	@Override
	protected String getCampo(Articulo articulo) {
		// TODO Auto-generated method stub
		return null;
	}

}
