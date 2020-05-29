package tp5.mercado;

import java.util.ArrayList;
import java.util.List;

public class AgenciaRecaudadora implements Agencia{

	private List<Factura> listaDeFacturas;

	public AgenciaRecaudadora() {
		listaDeFacturas = new ArrayList<Factura>();
	}
	
	

	public List<Factura> getListaDeFacturas() {
		return listaDeFacturas;
	}


	@Override
	public void registarPago(Factura factura) {
		listaDeFacturas.add(factura);
		
	}

}
