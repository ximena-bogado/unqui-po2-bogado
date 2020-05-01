package tp4.Ingresos;

import java.util.ArrayList;

public class Trabajador {
	
	private ArrayList<Ingreso> ingresosPercibidos;
	
	

	public Trabajador() {
		ingresosPercibidos = new ArrayList<Ingreso>();
	}

	public void addIngresoPercibido(Ingreso ingreso) {
		ingresosPercibidos.add(ingreso);
		
	}

	public Double getImpuestoAPagar() {
		return this.getMontoImponible() * 0.02d;
	}

	public Integer getMontoImponible() {
		Integer montoImponible = 0;
		for (Ingreso ingreso:ingresosPercibidos) {
			montoImponible += ingreso.getMontoImponible();
		}
		
		return montoImponible;
	}

	public Integer getTotalPercibido() {
		Integer impuestosAPagar = 0;
		for (Ingreso ingreso:ingresosPercibidos) {
			impuestosAPagar += ingreso.getMontoPercibido();
		}
		
		return impuestosAPagar;
	}

}
