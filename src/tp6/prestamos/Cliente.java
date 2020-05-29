package tp6.prestamos;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private String direccion;
	private Integer edad;
	private Integer sueldoNetoMensual;
	private PropiedadInmobiliaria propiedadInmobiliaria;

	public Cliente(String nombre, String apellido, String direccion, Integer edad, Integer sueldoNetoMensual) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.edad = edad;
		this.sueldoNetoMensual = sueldoNetoMensual;
	}

	public Integer getSueldoNetoAnual() {
		return sueldoNetoMensual * 12;
	}

	public void solicitarPrestamo(Banco banco, Solicitud solicitud) {
		banco.registrarSolicitud(solicitud);
	}

	public Integer getEdad() {
		return edad;
	}

	public Integer getSueldoNetoMensual() {
		return sueldoNetoMensual;
	}


	public PropiedadInmobiliaria getPropiedadInmobiliaria() {
		return propiedadInmobiliaria;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

}
