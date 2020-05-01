package tp3.unq;

import java.util.ArrayList;

public class MultiOperador {

	public Integer sumarTodo(ArrayList<Integer> contador) {
		Integer suma = 0;
		for (Integer i=0; i< contador.size(); i++) {
			suma += contador.get(i);
		}
		return suma;
	}

	public Integer restarTodo(ArrayList<Integer> contador) {
		Integer resta = contador.get(0);
		for (Integer i=1; i< contador.size(); i++) {
			resta -= contador.get(i);
		}
		return resta;
	}

	public Integer multiplicarTodo(ArrayList<Integer> contador) {
		Integer multiplicacion = 1;
		for (Integer i=0; i< contador.size(); i++) {
			multiplicacion *= contador.get(i);
		}
		return multiplicacion;
	}
	
	
	
}
