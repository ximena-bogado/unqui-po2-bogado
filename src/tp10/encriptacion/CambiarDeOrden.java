package tp10.encriptacion;

public class CambiarDeOrden implements EstrategiaDeEncriptar{

	@Override
	public String encriptar(String texto) {
		String[] partes = texto.split(" ");
		String textoInvertido = partes[0];
		
		for (int i=1 ; i<partes.length ; i++) {
			textoInvertido = partes[i] + " " + textoInvertido ;
		}
		
		return textoInvertido;
	}

	@Override
	public String desencriptar(String texto) {
		String[] partes = texto.split(" ");
		String textoInvertido = partes[0];
		
		for (int i=1 ; i<partes.length ; i++) {
			textoInvertido = partes[i] + " " + textoInvertido ;
		}
		
		return textoInvertido;
	}

}
