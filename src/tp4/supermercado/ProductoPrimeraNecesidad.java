package tp4.supermercado;

public class ProductoPrimeraNecesidad extends Producto{

	private Double descuento;

	
	public ProductoPrimeraNecesidad(String nombre, Double precio, Boolean b, Double e) {
		super(nombre,precio,b);
		descuento = e;
	}

	public Double getPrecio() {
		
		return  super.getPrecio() * descuento;
	}

}
