package tp6.prestamos;

public class SolicitudDeCreditoHipotecario extends SolicitudDeCredito {

	private PropiedadInmobiliaria garantia;

	public SolicitudDeCreditoHipotecario(Cliente cliente, Integer montoSolicitado, Integer cuotasMensuales) {
		super(cliente, montoSolicitado, cuotasMensuales);
		this.garantia = cliente.getPropiedadInmobiliaria();
	}
	
	

	public PropiedadInmobiliaria getGarantia() {
		return garantia;
	}



	@Override
	public Boolean realizarChequeo() {
		return this.chequearMontoDeCuota() & this.chequearMontoTotal() & this.chequearEdad();
	}



	private Boolean chequearEdad() {
		return this.a�osAlFinalizarPago() <= 65;
	}



	private Integer a�osAlFinalizarPago() {
		Cliente cliente = super.getCliente();
		Integer a�osParaPagar = super.getCuotasMensuales() / 12;
		return cliente.getEdad() + a�osParaPagar;
	}



	private Boolean chequearMontoTotal() {
		
		return super.getMontoSolicitado() > this.porcentajeDelValorFiscalDeGarantia();
	}



	private Double porcentajeDelValorFiscalDeGarantia() {
		return garantia.getValorFiscal() * 0.7 ;
	}



	private Boolean chequearMontoDeCuota() {
		
		return this.getMontoDeCuotaMensual() < this.porcentajeDeLosIngresosMensualesDelTitular();
	}



	private Double porcentajeDeLosIngresosMensualesDelTitular() {
		Cliente cliente = super.getCliente();
		return cliente.getSueldoNetoMensual() * 0.5;
	}

}
