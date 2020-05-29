package tp5.mercado;

public class FacturaDeServicio extends Factura{

	private Double costoPorUnidadConsumida;
	private Double cantidadDeUnidadesConsumidas;
	

	public FacturaDeServicio(Double costoPorUnidadConsumida, Double cantidadDeUnidadesConsumidas, Agencia agencia) {
		super(agencia);
		this.costoPorUnidadConsumida = costoPorUnidadConsumida;
		this.cantidadDeUnidadesConsumidas = cantidadDeUnidadesConsumidas;
	}



	@Override
	protected Double getMontoAPagar() {
		return this.costoPorUnidadConsumida * this.cantidadDeUnidadesConsumidas;
	}

}
