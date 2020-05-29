package tp6.prestamos;

public abstract class SolicitudDeCredito implements Solicitud{

	private Cliente cliente;
	private Integer montoSolicitado;
	private Integer cuotasMensuales;

	public SolicitudDeCredito(Cliente cliente, Integer montoSolicitado, Integer cuotasMensuales) {
		this.cliente = cliente;
		this.montoSolicitado = montoSolicitado;
		this.cuotasMensuales = cuotasMensuales;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Integer getMontoSolicitado() {
		return montoSolicitado;
	}

	public Integer getCuotasMensuales() {
		return cuotasMensuales;
	}

	public abstract Boolean realizarChequeo();

	public Integer getMontoDeCuotaMensual() {
		return montoSolicitado / cuotasMensuales;
	}
	
	

}
