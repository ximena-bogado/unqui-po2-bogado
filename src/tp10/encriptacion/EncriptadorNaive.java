package tp10.encriptacion;

public class EncriptadorNaive {
	
	private EstrategiaDeEncriptar estrategia;

	public EncriptadorNaive() {
		this.estrategia =  new CambiarDeOrden();
	}

	public String encriptar(String mensaje) {
		return estrategia.encriptar(mensaje);
	}
	
	public String desencriptar(String mensaje) {
		return estrategia.desencriptar(mensaje);
	}
	
	public void asignar(EstrategiaDeEncriptar estrategia) {
		this.estrategia = estrategia;
	}

}
