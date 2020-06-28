package tp09.publicaciones;

public class ReferenciaTipo extends ReferenciaNombre {

	public ReferenciaTipo(String referencia) {
		super(referencia);
		
	}

	@Override
	protected String getCampo(Articulo articulo) {
		
		return articulo.getTipo();
	}

}
