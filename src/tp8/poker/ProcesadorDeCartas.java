package tp8.poker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProcesadorDeCartas {
	
	public Boolean sonPalosIguales(List<Carta> listaDeCartas) {
		Boolean resultado = true;
		Carta cartaBase = listaDeCartas.get(0);
		
		for (Carta carta: listaDeCartas) {
			
			resultado = resultado & (carta.mismoPalo(cartaBase));
		}
		
		return resultado;
	}
	
	public Integer obtenerMaximaRepeticionDeValores(List<Carta> listaDeCartas) {
		HashMap<Integer, Integer> repeticionesDeValores = this.ObtenerRepeticionesDeValores(listaDeCartas);
		Integer maximo = 1;
		
		for (Integer repeticion : repeticionesDeValores.values()) {
			maximo = this.mayorEntre(maximo,repeticion);
		}
		return maximo;
		
	}
	
	private Integer mayorEntre(Integer maximo, Integer repeticion) {
		if (maximo < repeticion) {
			return repeticion;
		}else {
			return maximo;
		}
	}
	
	private HashMap<Integer, Integer> ObtenerRepeticionesDeValores(List<Carta> listaDeCartas) {
		HashMap<Integer, Integer> repeticiones = new HashMap<Integer, Integer>(); 

		for (Integer valor : this.obtenerValores(listaDeCartas)) { 
		    Integer repeticion = repeticiones.get(valor); 
		    if (repeticion == null) { 
		     repeticion = 0; 
		    } 
		    repeticiones.put(valor, repeticion + 1); 
		}
		return repeticiones;
	}
	
	private List<Integer> obtenerValores(List<Carta> listaDeCartas) {
		ArrayList<Integer> listaDeValores = new ArrayList<Integer>();
		
		for (Carta carta: listaDeCartas) {
			listaDeValores.add(carta.getValor().getValorNumerico());
		}
		
		return listaDeValores;
	}

}
