package tp03.unq;


import java.time.LocalDate;

import tp05.mascota.SerVivo;


public class Persona implements SerVivo{
	private String nombre;
	private LocalDate fechaDeNacimiento;
	
	
	public Persona(String nombre, LocalDate fechaDeNacimiento) {
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}


	public String getNombre() {
		return nombre;
	}


	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	
	
	public Integer getEdad(){
		LocalDate fechaDeNacimiento = this.getFechaDeNacimiento();
		LocalDate fechaDeHoy = LocalDate.now();
		Integer edad = 0;
		if (fechaDeNacimiento.getMonthValue() < fechaDeHoy.getMonthValue()) {
			edad = fechaDeHoy.getYear() - fechaDeNacimiento.getYear();
		}else {
			edad = fechaDeHoy.getYear() - fechaDeNacimiento.getYear() - 1;
		}
		
		return edad;
	}


	public Boolean menorQue(Persona persona1) {
		return this.getEdad() < persona1.getEdad();
	}
	

}
