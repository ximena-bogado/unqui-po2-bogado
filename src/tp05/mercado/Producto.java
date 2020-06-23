package tp05.mercado;

public abstract class Producto implements Pagable{
	
	private Double precio;
	private Integer stock;
	
	public Producto(Double precio, Integer stock) {
		this.precio = precio;
		this.stock = stock;
	}

	public Double getPrecio() {
		return precio;
	}
	
	public Double registrar() {
		this.decrementarStock();
		return getMontoAPagar();
	}
	
	protected abstract Double getMontoAPagar();

	public Integer getStock() {
		return stock;
	}

	private void decrementarStock() {
		stock -= 1;
	}

}
