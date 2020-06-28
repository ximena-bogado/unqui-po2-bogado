package tp08.poker;

public class ValorNumerico implements Valor {


	private Integer valorNumerico;

	public ValorNumerico(Integer valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	@Override
	public Boolean esMayor(Valor valor) {
		
		return this.getValorNumerico() > valor.getValorNumerico();
	}

	@Override
	public Integer getValorNumerico() {
		
		return valorNumerico;
	}

}
