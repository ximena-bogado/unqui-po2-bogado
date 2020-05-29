package tp9.publicaciones;

public abstract class Referencia {

	private String referencia;
	
	public Referencia(String referencia) {
		this.referencia = referencia;
	}

    public Boolean chequear(Articulo articulo) {
		
		return this.chequearCampo(this.getCampo(articulo));
	}
    
    protected Boolean chequearCampo(String campo) {
		// TODO Auto-generated method stub
		return campo.equals(referencia);
	}
	
	public String getReferencia() {
		return referencia;
	}
	
	protected abstract String getCampo(Articulo articulo);

}
