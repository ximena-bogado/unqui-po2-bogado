package tp4.Ingresos;

import java.time.Month;

public class IngresoPorHorasExtras extends Ingreso {

	private int cantidadDeHorasExtras;

	public IngresoPorHorasExtras(Month mes, String concepto, int monto, int cantidad) {
		super(mes,concepto,monto);
		cantidadDeHorasExtras = cantidad;
	}
	
	public Integer getMontoImponible() {
		return 0;
	}

}
