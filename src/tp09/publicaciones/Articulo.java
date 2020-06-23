package tp09.publicaciones;

import java.util.List;

public class Articulo {

	private List<String> palabrasClaves;
	private String editorial;
	private String tipo;
	private List<String> filiaciones;
	private List<String> autores;
	private String titulo;

	public Articulo(String titulo, List<String> listaDeAutores, List<String> listaDefiliaciones, String tipo, String editorial,
			List<String> palabrasClaves) {
		this.titulo = titulo;
		this.autores = listaDeAutores;
		this.filiaciones = listaDefiliaciones;
		this.tipo = tipo;
		this.editorial = editorial;
		this.palabrasClaves = palabrasClaves;
	}

	public String getTitulo() {
		
		return titulo;
	}

	public List<String> getAutores() {
		
		return autores;
	}

	public List<String> getFiliaciones() {
		
		return filiaciones;
	}

	public String getTipo() {
		
		return tipo;
	}

	public String getEditorial() {
		
		return editorial;
	}

	public List<String> getPalabrasClaves() {
		
		return palabrasClaves;
	}

}
