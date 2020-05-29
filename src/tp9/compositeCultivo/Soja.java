package tp9.compositeCultivo;

public class Soja implements Cultivo{

	@Override
	public Double gananciaAnual() {
		
		return 500d;
	}

	@Override
	public Double calcularGananciaAnual() {
		
		return this.gananciaAnual() / 4;
	}

}
