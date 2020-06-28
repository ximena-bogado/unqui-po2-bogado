package tp04.supermercado;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
	
	private String nombreDelSupermercado;
	private String direccion;
	private List<Producto> productos;

	public Supermercado(String nombre, String direccion) {
		this.nombreDelSupermercado = nombre;
		this.direccion = direccion;
		this.productos = new ArrayList<Producto>();
	}

	public void agregarProducto(Producto producto) {
		productos.add(producto);
		
	}

	public String getNombreDelSupermercado() {
		return nombreDelSupermercado;
	}

	public String getDireccion() {
		return direccion;
	}

	public Integer getCantidadDeProductos() {
		return productos.size();
	}

	public Double getPrecioTotal() {
		Double sumaDeProductos = 0d ;
		for (Producto producto: productos) {
			sumaDeProductos += producto.getPrecio();
		}
		return sumaDeProductos;
	}

}
