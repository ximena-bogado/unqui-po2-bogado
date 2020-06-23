package tp07.wikipedia;

import java.util.Map;

public class FiltroPropiedadEnComun extends Filtro {

	@Override
	protected Boolean chequear(WikipediaPage page1, WikipediaPage page2) {
		Boolean resultado = false;
		Map<String, WikipediaPage> infobox = page1.getInfobox();
		for (String propiedad: infobox.keySet()) {
			resultado = resultado || chequearPropiedad(propiedad, page2.getInfobox());
		}
		return resultado;
	}

	private Boolean chequearPropiedad(String propiedad, Map<String, WikipediaPage> infobox) {
		Boolean resultado = false;
		for (String propiedad2: infobox.keySet()) {
			resultado = resultado || super.chequearTitulos(propiedad, propiedad2);
		}
		return resultado;
	}


}
