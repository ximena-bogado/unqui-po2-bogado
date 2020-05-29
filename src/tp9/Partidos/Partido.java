package tp9.Partidos;

import java.util.List;

public class Partido {

	private String deporte;
	private List<String> contrincantes;
	private String resultado;



	public Partido(String deporte, List<String> contrincantes, String resultado) {
		this.deporte = deporte;
		this.contrincantes = contrincantes;
		this.resultado = resultado;
	}


	public String getDeporte() {
		// TODO Auto-generated method stub
		return deporte;
	}

	

	public List<String> getContrincantes() {
		// TODO Auto-generated method stub
		return contrincantes;
	}



	public String getResultado() {
		// TODO Auto-generated method stub
		return resultado;
	}

}
