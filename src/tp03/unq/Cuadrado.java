package tp03.unq;

public class Cuadrado extends Rectangulo {

	public Cuadrado(Point puntoInicial, Integer lado) {
		super(puntoInicial, lado, lado);
	}
	
	public Boolean esVertical() {
		return true;
	}


	public Boolean esHorizontal() {
		return true;
	}

}
