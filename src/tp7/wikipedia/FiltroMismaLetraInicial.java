package tp7.wikipedia;

public class FiltroMismaLetraInicial extends Filtro {

	@Override
	protected Boolean chequear(WikipediaPage page1, WikipediaPage page2) {
	
		return super.chequearTitulos(page1.getTitle(), page2.getTitle());
	}

	

}
