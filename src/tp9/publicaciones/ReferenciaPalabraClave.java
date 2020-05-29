package tp9.publicaciones;

public class ReferenciaPalabraClave extends Referencia {

	public ReferenciaPalabraClave(String referencia) {
		super(referencia);
		// TODO Auto-generated constructor stub
	}
	
	public Boolean chequear(Articulo articulo) {
		Boolean resultado = false;
		for(String palabraClave: articulo.getPalabrasClaves()) {
			resultado |= this.chequearCampo(palabraClave);
		}
		
		return resultado;
	}

	@Override
	protected String getCampo(Articulo articulo) {
		// TODO Auto-generated method stub
		return null;
	}

}
