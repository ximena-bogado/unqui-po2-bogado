package tp9.publicaciones;

public class ReferenciaTipo extends Referencia {

	public ReferenciaTipo(String referencia) {
		super(referencia);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getCampo(Articulo articulo) {
		// TODO Auto-generated method stub
		return articulo.getTipo();
	}

}
