package tp5.mercado;

import java.util.List;

public interface Agencia {

	public void registarPago(Factura factura);

	public List<Factura> getListaDeFacturas();
}
