package tp09.publicaciones;

public class ReferenciaTitulo extends Referencia {


	public ReferenciaTitulo(String titulo) {
		super(titulo);
	}

	protected String getCampo(Articulo articulo) {
		
		return articulo.getTitulo();
	}

}
