package tp09.publicaciones;

import java.util.List;

public interface Suscriptor {

	void recibirArticulo(Articulo articulo);

	List<IReferencia> getReferencias();

}
