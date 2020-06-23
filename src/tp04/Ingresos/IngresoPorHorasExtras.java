package tp04.Ingresos;

import java.time.Month;

public class IngresoPorHorasExtras extends Ingreso {

	private Integer cantidadDeHorasExtras;

	public IngresoPorHorasExtras(Month mes, String concepto, Integer monto, Integer cantidad) {
		super(mes,concepto,monto);
		cantidadDeHorasExtras = cantidad;
	}
	
	public Integer getCantidadDeHorasExtras() {
		return cantidadDeHorasExtras;
	}

	public Integer getMontoImponible() {
		return 0;
	}

}
