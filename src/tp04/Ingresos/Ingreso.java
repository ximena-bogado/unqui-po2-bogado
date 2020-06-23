package tp04.Ingresos;

import java.time.Month;

public class Ingreso {

	private Integer montoPercibido;
	private Month mesDePercepcion;
	private String concepto;

	public Ingreso(Month mes, String concepto, Integer monto) {
		this.mesDePercepcion = mes;
		this.concepto = concepto;
		this.montoPercibido = monto;
	}

	public Month getMesDePercepcion() {
		return mesDePercepcion;
	}

	public String getConcepto() {
		return concepto;
	}

	public Integer getMontoPercibido() {
		return montoPercibido;
	}

	public Integer getMontoImponible() {
		return montoPercibido;
	}

}
