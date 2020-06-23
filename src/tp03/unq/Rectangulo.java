package tp03.unq;

public class Rectangulo {
	private Point puntoInicial;
	private Integer base;
	private Integer altura;
	

	public Rectangulo(Point puntoInicial, Integer base, Integer altura) {
		this.puntoInicial = puntoInicial;
		this.base = base;
		this.altura = altura;
	}


	public Integer getBase() {
		return base;
	}



	public Integer getAltura() {
		return altura;
	}



	public Integer obtenerElPerimetro() {
		return 2 * (this.getBase() + this.getAltura());
	}
	
	
	public Integer obtenerElArea() {
		return this.getBase() * this.getAltura();
	}


	public Boolean esVertical() {
		return this.getAltura() > this.getBase();
	}


	public Boolean esHorizontal() {
		return this.getBase() > this.getAltura();
	}
	
	


}
