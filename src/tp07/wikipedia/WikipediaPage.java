package tp07.wikipedia;

import java.util.List;
import java.util.Map;

public interface WikipediaPage {
	
	String getTitle(); 
	/*retorna el t�tulo de la p�gina.*/
	
	List<WikipediaPage> getLinks(); 
	/*retorna una Lista de las p�ginas de
	Wikipedia con las que se conecta.*/
	
	Map<String, WikipediaPage> getInfobox(); 
	/*retorna un Map con un valor en texto y la pagina que describe ese valor 
	 * que aparecen en los infobox de la p�gina de Wikipedia.*/

}
