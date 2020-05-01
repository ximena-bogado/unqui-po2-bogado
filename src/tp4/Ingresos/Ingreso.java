package tp4.Ingresos;

import java.time.Month;

public class Ingreso {

	private Integer montoPercibido;
	private Month mesDePercepcion;
	private String concepto;

	public Ingreso(Month mes, String c, Integer monto) {
		mesDePercepcion = mes;
		concepto = c;
		montoPercibido = monto;
	}

	public Integer getMontoPercibido() {
		return montoPercibido;
	}

	public Integer getMontoImponible() {
		return montoPercibido;
	}

}
