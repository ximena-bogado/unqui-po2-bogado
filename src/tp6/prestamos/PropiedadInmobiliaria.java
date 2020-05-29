package tp6.prestamos;

public class PropiedadInmobiliaria {

	private String descripcion;
	private String direccion;
	private Integer valorFiscal;
	
	
	
	public PropiedadInmobiliaria(String descripcion, String direccion, Integer valorFiscal) {
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.valorFiscal = valorFiscal;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public Integer getValorFiscal() {
		return valorFiscal;
	}



}
