package tp4.supermercado;

import java.util.ArrayList;

public class Supermercado {
	
	private String nombreDelSupermercado;
	private String direccion;
	private ArrayList<Producto> productos;

	public Supermercado(String nombre, String d) {
		nombreDelSupermercado = nombre;
		direccion = d;
		productos = new ArrayList<Producto>();
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
		
	}

	public Integer getCantidadDeProductos() {
		return productos.size();
	}

	public Double getPrecioTotal() {
		ArrayList<Producto> listaDeProductos = productos;
		Double sumaDeProductos = 0.0 ;
		for (Producto producto:listaDeProductos) {
			sumaDeProductos += producto.getPrecio();
		}
		return sumaDeProductos;
	}

}
