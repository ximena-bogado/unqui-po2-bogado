package tp09.publicaciones;

import java.util.List;

public class ReferenciaFiliaciones extends ReferenciaLista {

	public ReferenciaFiliaciones(String referencia) {
		super(referencia);
	
	}

	@Override
	protected List<String> getCampo(Articulo articulo) {
		
		return articulo.getFiliaciones();
	}

}
