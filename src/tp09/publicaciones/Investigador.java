package tp09.publicaciones;

import java.util.ArrayList;
import java.util.List;

public class Investigador implements Suscriptor{

	private List<IReferencia> listaDeReferencias;
	private List<Articulo> articulos;

	public Investigador() {
		listaDeReferencias = new ArrayList<IReferencia>();
		articulos = new ArrayList<Articulo>();
	}

	public void cargarArticulo(Articulo articulo, SistemaDePublicaciones sistemaDePublicaciones) {
		sistemaDePublicaciones.agregarArticulo(articulo);
		
	}

	public void suscribirse(IReferencia referencia, SistemaDePublicaciones sistema) {
		sistema.agregarSuscriptor(this);
		listaDeReferencias.add(referencia);
		
	}

	@Override
	public void recibirArticulo(Articulo articulo) {
		articulos.add(articulo);
		
	}

	@Override
	public List<IReferencia> getReferencias() {
		
		return listaDeReferencias;
	}

	public List<Articulo> getArticulos() {
		
		return articulos;
	}

}
