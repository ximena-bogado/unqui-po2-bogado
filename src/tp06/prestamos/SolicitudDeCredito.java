package tp06.prestamos;

public abstract class SolicitudDeCredito implements Solicitud{

	private Cliente cliente;
	private Double montoSolicitado;
	private Integer cuotasMensuales;

	public SolicitudDeCredito(Cliente cliente, Double montoSolicitado, Integer cuotasMensuales) {
		this.cliente = cliente;
		this.montoSolicitado = montoSolicitado;
		this.cuotasMensuales = cuotasMensuales;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	public Integer getCuotasMensuales() {
		return cuotasMensuales;
	}

	public abstract Boolean realizarChequeo();

	public Double getMontoDeCuotaMensual() {
		return montoSolicitado / cuotasMensuales;
	}
	
	

}
