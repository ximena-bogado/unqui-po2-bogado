package tp4.supermercado;


public class Producto {
	
	private String nombreDelProducto;
	private Double precio;
	private Boolean esPrecioCuidado;

	public Producto(String nombre, Double p, Boolean b) {
		nombreDelProducto = nombre;
		precio = p;
		esPrecioCuidado = b;
	}
	

	public void setNombreDelProducto(String nombreDelProducto) {
		this.nombreDelProducto = nombreDelProducto;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public void setEsPrecioCuidado(Boolean esPrecioCuidado) {
		this.esPrecioCuidado = esPrecioCuidado;
	}



	public Producto(String nombre, double p) {
		nombreDelProducto = nombre;
		precio = p;
		esPrecioCuidado = false;
	}

	public Boolean esPrecioCuidado() {
		return this.esPrecioCuidado;
	}

	public Object getNombre() {
		return this.nombreDelProducto;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void aumentarPrecio(double d) {
		precio += d;
		
	}

	



}
