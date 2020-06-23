package tp06.prestamos;

public class SolicitudDeCreditoHipotecario extends SolicitudDeCredito {

	private PropiedadInmobiliaria garantia;

	public SolicitudDeCreditoHipotecario(Cliente cliente, Double montoSolicitado, Integer cuotasMensuales) {
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
		return this.añosAlFinalizarPago() <= 65;
	}



	private Integer añosAlFinalizarPago() {
		Cliente cliente = this.getCliente();
		Integer añosParaPagar = this.getCuotasMensuales() / 12;
		return cliente.getEdad() + añosParaPagar;
	}



	private Boolean chequearMontoTotal() {
		
		return this.getMontoSolicitado() <= this.porcentajeDelValorFiscalDeGarantia();
	}



	private Double porcentajeDelValorFiscalDeGarantia() {
		return garantia.getValorFiscal() * 0.7 ;
	}



	private Boolean chequearMontoDeCuota() {
		
		return this.getMontoDeCuotaMensual() < this.porcentajeDeLosIngresosMensualesDelTitular();
	}



	private Double porcentajeDeLosIngresosMensualesDelTitular() {
		Cliente cliente = this.getCliente();
		return cliente.getSueldoNetoMensual() * 0.5;
	}

}
