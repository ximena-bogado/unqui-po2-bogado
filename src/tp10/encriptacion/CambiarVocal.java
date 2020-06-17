package tp10.encriptacion;

public class CambiarVocal implements EstrategiaDeEncriptar{

	@Override
	public String encriptar(String texto) {
		String nuevoTexto = "";
		
		for (int i=0 ; i<texto.length() ; i++) {
			String letraActual = texto.charAt(i)+"";
			nuevoTexto += this.cambiarSiEsVocal(letraActual);
		}
		
		return nuevoTexto;
	}


	@Override
	public String desencriptar(String texto) {
        String nuevoTexto = "";
		
		for (int i=0 ; i<texto.length() ; i++) {
			String letraActual = texto.charAt(i)+"";
			nuevoTexto += this.invertirSiEsVocal(letraActual);
		}
		
		return nuevoTexto;
	}
	
	private String invertirSiEsVocal(String letraActual) {
		String vocales = "aeiou";
		
		if (vocales.contains(letraActual)){
			letraActual = this.vocalAnterior(vocales, letraActual);
		}
		return letraActual;
	}


	private String vocalAnterior(String vocales, String letraActual) {
		
		if(letraActual == "a") {
			letraActual = vocales.charAt(vocales.length() -1 )+"";
		}else {
			Integer posicionDeVocal = vocales.indexOf(letraActual);
			letraActual = vocales.charAt(posicionDeVocal - 1)+"";
		}
		
		return letraActual;
	}


	private String cambiarSiEsVocal(String letraActual) {
		String vocales = "aeiou";
		
		if (vocales.contains(letraActual)){
			letraActual = this.vocalSiguiente(vocales, letraActual);
		}
		return letraActual;
	}


	private String vocalSiguiente(String vocales, String letraActual) {
		Integer posicionDeVocal = vocales.indexOf(letraActual);
		
		return vocales.charAt(posicionDeVocal + 1)+"";
	}

}
