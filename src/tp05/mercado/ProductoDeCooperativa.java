package tp05.mercado;

public class ProductoDeCooperativa extends Producto {

	public ProductoDeCooperativa(Double precio, Integer stock) {
		super(precio, stock);
	}

	@Override
	protected Double getMontoAPagar() {
		return super.getPrecio() * 0.9;
	}



}
