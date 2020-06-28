package tp03.unq;

import java.util.ArrayList;

public class Counter {
	
	private ArrayList<Integer> listaDeNumeros;
	
	public Counter() {
		this.listaDeNumeros =  new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getContador() {
		return listaDeNumeros;
	}

	public Integer cantidadDePares() {
		ArrayList<Integer> array = this.listaDeNumeros;
		Integer cantidadDePares = 0;
		for (Integer i=0; i< array.size(); i++) {
			cantidadDePares += this.devolverUnoSiEsPar(array.get(i));
		}
		return cantidadDePares;
	}


	public Integer cantidadDeImpares() {
		ArrayList<Integer> array = this.listaDeNumeros;
		Integer cantidadDeImpares = 0;
		for (Integer i=0; i< array.size(); i++) {
			cantidadDeImpares += this.devolverUnoSiEsImpar(array.get(i));
		}
		return cantidadDeImpares;
	}

	
	public Integer cantidadDeMultiplosDe(Integer numero) {
		ArrayList<Integer> array = this.listaDeNumeros;
		Integer cantidadDeMultiplos = 0;
		for (Integer i=0; i< array.size(); i++) {
			cantidadDeMultiplos += this.devolverUnoSiEsMultiploDe(array.get(i),numero);
		}
		return cantidadDeMultiplos;
	}


	public void addNumber(Integer i) {
		this.listaDeNumeros.add(i);
	}

	private Integer devolverUnoSiEsMultiploDe(Integer integer, Integer numero) {
		if (integer % numero == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	private Integer devolverUnoSiEsImpar(Integer integer) {
		if (integer % 2 == 0) {
			return 0;
		} else {
			return 1;
		}
	}
	
	private Integer devolverUnoSiEsPar(Integer integer) {
		if (integer % 2 == 0) {
			return 1;
		} else {
			return 0;
		}
	}



}
