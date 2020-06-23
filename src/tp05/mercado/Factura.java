package tp05.mercado;

public abstract class Factura implements Pagable{

	private Agencia agencia;
	
	public Factura(Agencia agencia) {
		this.agencia = agencia;
	}

	@Override
	public Double registrar() {
		agencia.registarPago(this);
		
		return this.getMontoAPagar();

	}

	protected abstract Double getMontoAPagar();
	
}
