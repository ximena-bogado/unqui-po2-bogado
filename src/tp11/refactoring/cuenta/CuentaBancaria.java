package tp11.refactoring.cuenta;

public abstract class CuentaBancaria {
	protected HistorialMovimientos historialDeMovimientos;
	protected Notificador notificador;
	protected Integer saldo;
	
	public CuentaBancaria(HistorialMovimientos historialDeMovimientos, Notificador notificador, Integer saldo) {
		super();
		this.historialDeMovimientos = historialDeMovimientos;
		this.notificador = notificador;
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;
	}
	
	public void extraer(Integer monto) {
		if(this.puedeExtraer(monto)) {
			this.descontarMonto(monto);
			this.registrarMovimiento(monto);
			this.notificarNuevoSaldoACliente();
		}
	}

	protected abstract void notificarNuevoSaldoACliente();

	protected abstract void registrarMovimiento(Integer monto);

	protected abstract void descontarMonto(Integer monto);

	protected abstract boolean puedeExtraer(Integer monto);
}
