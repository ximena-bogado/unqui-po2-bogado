package tp09.publicaciones;

public abstract class ReferenciaNombre implements IReferencia{

	private String referencia;
	
	public ReferenciaNombre(String referencia) {
		this.referencia = referencia;
	}

    public Boolean chequear(Articulo articulo) {
		
		return this.chequearCampo(this.getCampo(articulo));
	}
    
    protected Boolean chequearCampo(String campo) {
		// TODO Auto-generated method stub
		return campo.equals(referencia);
	}
	
	protected abstract String getCampo(Articulo articulo);

}
