package tp7.wikipedia;

import java.util.ArrayList;
import java.util.List;

public abstract class Filtro {

	public List<WikipediaPage> getSimilarPages(WikipediaPage page1, List<WikipediaPage> listaDePaginas) {
		List<WikipediaPage> listaDePaginasSimilares = new ArrayList<WikipediaPage>();
		for (WikipediaPage page: listaDePaginas) {
			agregarAListaSiPasaElFiltro(page1, page, listaDePaginasSimilares);
		}
		return listaDePaginasSimilares;
	}

	private void agregarAListaSiPasaElFiltro(WikipediaPage page1, WikipediaPage page2, List<WikipediaPage> listaDePaginasSimilares) {
		if (chequear(page1, page2)) {
			listaDePaginasSimilares.add(page2);
		}
		
	}

	protected abstract Boolean chequear(WikipediaPage page1, WikipediaPage page2);
	
	protected Boolean chequearTitulos(String title1, String title2) {

		return title1 == title2;
	}

}
