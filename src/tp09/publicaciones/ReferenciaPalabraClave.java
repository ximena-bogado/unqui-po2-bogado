package tp09.publicaciones;

import java.util.List;

public class ReferenciaPalabraClave extends ReferenciaLista {

	public ReferenciaPalabraClave(String referencia) {
		super(referencia);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected List<String> getCampo(Articulo articulo) {
		return articulo.getPalabrasClaves();
	}

}
