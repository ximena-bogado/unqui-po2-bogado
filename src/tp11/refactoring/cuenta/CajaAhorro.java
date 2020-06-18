package tp11.refactoring.cuenta;

public class CajaAhorro extends CuentaBancaria{

	public CajaAhorro(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super(historialDeMovimientos, notificador, saldo);
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
		
		return this.saldo >= monto;
	}
	

}
