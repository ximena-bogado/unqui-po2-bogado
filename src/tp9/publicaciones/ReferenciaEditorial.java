package tp9.publicaciones;

public class ReferenciaEditorial extends Referencia {

	public ReferenciaEditorial(String referencia) {
		super(referencia);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String getCampo(Articulo articulo) {
		// TODO Auto-generated method stub
		return articulo.getEditorial();
	}

}
