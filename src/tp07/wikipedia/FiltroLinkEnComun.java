package tp07.wikipedia;

import java.util.List;

public class FiltroLinkEnComun extends Filtro {

	@Override
	protected Boolean chequear(WikipediaPage page1, WikipediaPage page2) {
		Boolean resultado = false;
		for (WikipediaPage link: page1.getLinks()) {
			resultado = resultado || chequearLink(link, page2.getLinks());
		}
		return resultado;

	}

	private Boolean chequearLink(WikipediaPage link1, List<WikipediaPage> links) {
		Boolean resultado = false;
		for (WikipediaPage link2: links) {
			resultado = resultado || super.chequearTitulos(link1.getTitle(), link2.getTitle());
		}
		return resultado;
	}

}
