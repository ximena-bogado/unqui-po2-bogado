package tp08.poker;

public class Valor {

	public Integer valorNumerico;
	
	public Valor(Integer i) {
		this.valorNumerico = i;
	}
	
	public Boolean esMayor(Valor valor) {
		
		return this.valorNumerico > valor.valorNumerico;
	}

	public Integer getValorNumerico() {
		
		return valorNumerico;
	}

}
