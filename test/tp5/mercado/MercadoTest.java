package tp5.mercado;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MercadoTest {
	
	private Caja caja;
	private Producto productoCoop;
	private Producto productoEmp;
	private Cliente cliente;
	private Factura facturaServicios;
	private Factura facturaImpuestos;
	private Agencia agenciaRecaudadora;

	@BeforeEach
	public void setUp() {
		agenciaRecaudadora = new AgenciaRecaudadora();
		caja = new Caja();
		productoCoop = new ProductoDeCooperativa(100d,5);
		productoEmp = new ProductoDeEmpresaTradicional(200d,10);
		cliente = new Cliente();
		facturaServicios = new FacturaDeServicio(1000d, 10d, agenciaRecaudadora);
		facturaImpuestos = new FacturaDeImpuestos(800d, agenciaRecaudadora);
		
		cliente.agregarAListaDeCosasAPagar(productoCoop);
		cliente.agregarAListaDeCosasAPagar(productoEmp);
		
	}
	
	@Test
	void testRegistrarproducto() {
		Double precioDelProducto = productoCoop.registrar();
		
		assertEquals(90,precioDelProducto);
		assertEquals(4,productoCoop.getStock());
		
        Double precioDelProducto2 = productoEmp.registrar();
		
		assertEquals(200,precioDelProducto2);
		assertEquals(9,productoEmp.getStock());
		
		Double montoAPagarDeFactura = facturaServicios.registrar();
		Double montoAPagarDeFactura2 = facturaImpuestos.registrar();
		
		assertEquals(10000,montoAPagarDeFactura);
		assertEquals(800,montoAPagarDeFactura2);
	}
	
	@Test
	void testInformarMontoAPagar() {
		Double montoAPagar = caja.informarMontoAPagar(cliente);
		
		assertEquals(290,montoAPagar);
		
		cliente.agregarAListaDeCosasAPagar(facturaServicios);
		cliente.agregarAListaDeCosasAPagar(facturaImpuestos);
		
        Double montoAPagar2 = caja.informarMontoAPagar(cliente);
		
		assertEquals(11090,montoAPagar2);
		
		List<Factura> listaDeFacturas = agenciaRecaudadora.getListaDeFacturas();
		
		assertEquals(2,listaDeFacturas.size());
		
	}

}
