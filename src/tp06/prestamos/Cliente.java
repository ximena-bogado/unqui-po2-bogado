package tp06.prestamos;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private String direccion;
	private Integer edad;
	private Double sueldoNetoMensual;
	private PropiedadInmobiliaria propiedadInmobiliaria;

	public Cliente(String nombre, String apellido, String direccion, Integer edad, Double d, PropiedadInmobiliaria garantia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.edad = edad;
		this.sueldoNetoMensual = d;
		this.propiedadInmobiliaria = garantia;
	}

	public Double getSueldoNetoAnual() {
		return sueldoNetoMensual * 12;
	}

	public void solicitarPrestamo(Banco banco, Solicitud solicitud) {
		banco.registrarSolicitud(solicitud);
	}

	public Integer getEdad() {
		return edad;
	}

	public Double getSueldoNetoMensual() {
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
