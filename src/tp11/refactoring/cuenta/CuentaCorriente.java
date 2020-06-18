package tp11.refactoring.cuenta;

public class CuentaCorriente extends CuentaBancaria{
	private Integer limiteDescubierto;
	
	public CuentaCorriente(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo, Integer limiteDescubierto) {
		super(historialDeMovimientos, notificador, saldo);
		this.limiteDescubierto = limiteDescubierto;
	}
	
	@Override
	protected void notificarNuevoSaldoACliente() {
		this.notificador.notificarNuevoSaldoACliente(this);
	}

	@Override
	protected void registrarMovimiento(Integer monto) {
		this.historialDeMovimientos.registrarMovimiento("Extracción", monto);
	}

	@Override
	protected void descontarMonto(Integer monto) {
		this.saldo = saldo - monto;
	}

	@Override
	protected boolean puedeExtraer(Integer monto) {
		return this.saldo + this.limiteDescubierto >= monto;
	}

}
