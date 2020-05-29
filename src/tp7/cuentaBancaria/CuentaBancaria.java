package tp7.cuentaBancaria;

import java.util.ArrayList;
import java.util.List;

public abstract class CuentaBancaria {
	private String titular;
	private int saldo;
	private List<String> movimientos;
	
	public CuentaBancaria(String titular){
		this.titular=titular;
		this.saldo=0;
		this.movimientos=new ArrayList<String>();
	}
	
	public String getTitular(){
		return this.titular;
	}
	
	public int getSaldo(){
		return this.saldo;
	}
	
	protected void setSaldo(int monto){
		this.saldo=monto;
	}
	
	
	public void extraer(int monto){
		if(puedeExtraer(monto)){
			actualizarSaldo(monto);
			this.agregarMovimientos("Extraccion");
		}
	}
	
	protected abstract boolean puedeExtraer(int monto);
	
	private void actualizarSaldo(int monto) {
		this.saldo += monto;
	}

	private void agregarMovimientos(String movimiento){
		this.movimientos.add(movimiento);
	}

}
