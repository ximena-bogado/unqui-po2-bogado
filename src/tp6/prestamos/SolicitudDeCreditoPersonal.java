package tp6.prestamos;

public class SolicitudDeCreditoPersonal extends SolicitudDeCredito {

	public SolicitudDeCreditoPersonal(Cliente cliente, Integer montoSolicitado, Integer cuotasMensuales) {
		super(cliente,montoSolicitado,cuotasMensuales);
	}

	@Override
	public Boolean realizarChequeo() {
		
		return this.chequearIngresos() & this.chequearMontoDeCuota();
	}

	private Boolean chequearMontoDeCuota() {
		Cliente cliente = super.getCliente();
		
		return cliente.getSueldoNetoAnual() > 15000;
	}

	private Boolean chequearIngresos() {
    Cliente cliente = super.getCliente();
    Integer sueldoNetoMensual = cliente.getSueldoNetoMensual();
	return super.getMontoDeCuotaMensual() <= this.porcentajeDeIngresosMensuales(sueldoNetoMensual);
	}

	private Double porcentajeDeIngresosMensuales(Integer sueldoNetoMensual) {
		
		return sueldoNetoMensual * 0.7;
	}

}
