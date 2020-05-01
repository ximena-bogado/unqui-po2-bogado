package tp3.equipo;

import java.util.ArrayList;

public class EquipoDeTrabajo {
	
	private String nombre;
	private ArrayList<Persona> conjuntoDeIntegrantes;
	
	
	public EquipoDeTrabajo(String nombre) {
		this.nombre = nombre;
		this.conjuntoDeIntegrantes = new ArrayList<Persona>();
	}


	public String getNombre() {
		return nombre;
	}


	public void agregarAlEquipo(Persona persona) {
		this.conjuntoDeIntegrantes.add(persona);
	}


	public Integer promedioDeEdad() {
		Integer promedioDeEdad = 0;
		
		for (Persona persona:this.conjuntoDeIntegrantes) {
			promedioDeEdad += persona.getEdad();
		}
		
		return (promedioDeEdad / this.conjuntoDeIntegrantes.size());
	}
	
	

}
