package tp6.prestamos;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private List<Solicitud> listaDeSolicitudes;
	private List<Cliente> listaDeClientes;

	public Banco() {
		this.listaDeClientes = new ArrayList<Cliente>();
		this.listaDeSolicitudes = new ArrayList<Solicitud>();
	}
	
	
	public Integer otorgarPrestamo(Solicitud solicitud) {
		if (this.evaluarSolicitud(solicitud)) {
			return this.desembolsarMontoEnEfectivo(solicitud);
		}
		return 0;
	}
	
	private Integer desembolsarMontoEnEfectivo(Solicitud solicitud) {
		Integer montoSolicitado = solicitud.getMontoSolicitado();
		return montoSolicitado;
	}


	private Boolean evaluarSolicitud(Solicitud solicitud) {
		
		return solicitud.realizarChequeo();
	}


	public void registrarCliente(Cliente cliente) {
		this.listaDeClientes.add(cliente);
		
	}
	
	public void registrarSolicitud(Solicitud solicitud) {
		this.listaDeSolicitudes.add(solicitud);
		
	}


	public Integer montoTotalDeDineroADesembolsar() {
		Integer montoTotal = 0;
		for (Solicitud solicitud: this.listaDeSolicitudes) {
			montoTotal += solicitud.getMontoSolicitado();
		}
		return montoTotal;
	}


}
