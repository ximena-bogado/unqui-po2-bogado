package tp10.encriptacion;

public class CambiarPorNumero implements EstrategiaDeEncriptar{

	
	
	@Override
	public String encriptar(String texto) {
		String s = " abcdefghijklmnopqrstuvwxyz";
		String textoEncriptado = texto;
		
        for (int i=0; i<s.length() ; i++) {
        	
        	textoEncriptado = textoEncriptado.replace(s.charAt(i)+"", i+",");
        }

		return textoEncriptado;
	}

	@Override
	public String desencriptar(String texto) {
        String s = " abcdefghijklmnopqrstuvwxyz";
        String textoEncriptado = texto; 
		
        for (int i=0; i<s.length() ; i++) {
        	Integer posicionActual = s.length() - 1 - i;
        	textoEncriptado = textoEncriptado.replace(posicionActual+",", s.charAt(posicionActual)+"");
        }

		return textoEncriptado;
		
	}

}
