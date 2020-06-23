package tp06.prestamos;

public class SolicitudDeCreditoPersonal extends SolicitudDeCredito {

	public SolicitudDeCreditoPersonal(Cliente cliente, Double montoSolicitado, Integer cuotasMensuales) {
		super(cliente,montoSolicitado,cuotasMensuales);
	}

	@Override
	public Boolean realizarChequeo() {
		
		return this.chequearIngresoAnual() & this.chequearMontoDeCuota();
	}

	private Boolean chequearIngresoAnual() {
		Cliente cliente = this.getCliente();
		
		return cliente.getSueldoNetoAnual() > 15000;
	}

	private Boolean chequearMontoDeCuota() {
    Cliente cliente = this.getCliente();
    Double sueldoNetoMensual = cliente.getSueldoNetoMensual();
	return super.getMontoDeCuotaMensual() <= this.porcentajeDeIngresosMensuales(sueldoNetoMensual);
	}

	private Double porcentajeDeIngresosMensuales(Double sueldoNetoMensual) {
		
		return sueldoNetoMensual * 0.7;
	}

}
