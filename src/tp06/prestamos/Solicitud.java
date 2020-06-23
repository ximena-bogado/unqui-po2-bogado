package tp06.prestamos;

public interface Solicitud {
	
	public Boolean realizarChequeo();
	
	public Double getMontoSolicitado();

	public Cliente getCliente();

}
