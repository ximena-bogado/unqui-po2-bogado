package tp7.wikipedia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FiltroTest {
	
	private WikipediaPage page1;
	private WikipediaPage page2;
	private WikipediaPage page3;
	private WikipediaPage page4;
	private Filtro filtroLetra;
	private Filtro filtroLink;
	private Filtro filtroPropiedad;
	private WikipediaPage page5;

	
	@BeforeEach
	void testSetUp() {
		List<WikipediaPage> listaVacia =  new ArrayList<WikipediaPage>();
		HashMap<String, WikipediaPage> infoboxVacio = new HashMap<String, WikipediaPage>();
		
		WikipediaPage link1 = new WikipediaPageC("Hola", listaVacia, infoboxVacio);
		WikipediaPage link2 = new WikipediaPageC("Chau", listaVacia, infoboxVacio);
		WikipediaPage link3 = new WikipediaPageC("Perro", listaVacia, infoboxVacio);
		WikipediaPage link4 = new WikipediaPageC("Gato", listaVacia, infoboxVacio);
		
		List<WikipediaPage> links1 = new ArrayList<WikipediaPage>();
		links1.add(link1);
		
		List<WikipediaPage> links2 = new ArrayList<WikipediaPage>();
		links2.add(link1);
		links2.add(link3);
		
		List<WikipediaPage> links3 = new ArrayList<WikipediaPage>();
		links3.add(link2);
		
		List<WikipediaPage> links4 = new ArrayList<WikipediaPage>();
		links4.add(link2);
		links4.add(link4);
		
		HashMap<String, WikipediaPage> infobox1 = new HashMap<String, WikipediaPage>();
		infobox1.put("informatico", page2);
		infobox1.put("cadena", page4);
		
		HashMap<String, WikipediaPage> infobox4 = new HashMap<String, WikipediaPage>();
		infobox4.put("informatico", page2);
		
		HashMap<String, WikipediaPage> infobox3 = new HashMap<String, WikipediaPage>();
		infobox3.put("java", page3);
		
		HashMap<String, WikipediaPage> infobox2 = new HashMap<String, WikipediaPage>();
		infobox2.put("java", page3);
		infobox2.put("plata", page1);
		
		page1 = new WikipediaPageC("Hola", links1, infobox1);
		page2 = new WikipediaPageC("Chau", links2, infobox2);
		page3 = new WikipediaPageC("Chau", links3, infobox3);
		page4 = new WikipediaPageC("Hola", links4, infobox4);
		page5 = new WikipediaPageC("Perro", listaVacia, infoboxVacio);
		
		filtroLetra = new FiltroMismaLetraInicial();
		filtroLink = new FiltroLinkEnComun();
		filtroPropiedad = new FiltroPropiedadEnComun();
		
	}
	
	
	@Test
	void testSimilaresPorTitulo() {
		List<WikipediaPage> listaDePaginas = new ArrayList<WikipediaPage>();
		listaDePaginas.add(page4);
		listaDePaginas.add(page3);
		
		List<WikipediaPage> listaEsperada1 = new ArrayList<WikipediaPage>();
		listaEsperada1.add(page4);
		List<WikipediaPage> listaEsperada2 = new ArrayList<WikipediaPage>();
		listaEsperada2.add(page3);
		List<WikipediaPage> listaEsperada3 = new ArrayList<WikipediaPage>();
		
		List<WikipediaPage> listaDeSimilares1 = filtroLetra.getSimilarPages(page1,listaDePaginas);
		List<WikipediaPage> listaDeSimilares2 = filtroLetra.getSimilarPages(page2,listaDePaginas);
		List<WikipediaPage> listaDeSimilares3 = filtroLetra.getSimilarPages(page5,listaDePaginas);
		
		assertEquals(listaEsperada1,listaDeSimilares1);
		assertEquals(listaEsperada2,listaDeSimilares2);
		assertEquals(listaEsperada3,listaDeSimilares3);
	}
	
	@Test
	void testSimilaresPorLinks() {
		List<WikipediaPage> listaDePaginas = new ArrayList<WikipediaPage>();
		listaDePaginas.add(page2);
		listaDePaginas.add(page4);
		
		List<WikipediaPage> listaEsperada1 = new ArrayList<WikipediaPage>();
		listaEsperada1.add(page2);
		List<WikipediaPage> listaEsperada2 = new ArrayList<WikipediaPage>();
		listaEsperada2.add(page4);
		List<WikipediaPage> listaEsperada3 = new ArrayList<WikipediaPage>();
		
		List<WikipediaPage> listaDeSimilares1 = filtroLink.getSimilarPages(page1,listaDePaginas);
		List<WikipediaPage> listaDeSimilares2 = filtroLink.getSimilarPages(page3,listaDePaginas);
		List<WikipediaPage> listaDeSimilares3 = filtroLink.getSimilarPages(page5,listaDePaginas);
		
		assertEquals(listaEsperada1,listaDeSimilares1);
		assertEquals(listaEsperada2,listaDeSimilares2);
		assertEquals(listaEsperada3,listaDeSimilares3);
	}
	
	@Test
	void testSimilaresPorPropiedad() {
		List<WikipediaPage> listaDePaginas = new ArrayList<WikipediaPage>();
		listaDePaginas.add(page2);
		listaDePaginas.add(page4);
		
		List<WikipediaPage> listaEsperada1 = new ArrayList<WikipediaPage>();
		listaEsperada1.add(page4);
		List<WikipediaPage> listaEsperada2 = new ArrayList<WikipediaPage>();
		listaEsperada2.add(page2);
		List<WikipediaPage> listaEsperada3 = new ArrayList<WikipediaPage>();
		
		List<WikipediaPage> listaDeSimilares1 = filtroPropiedad.getSimilarPages(page1,listaDePaginas);
		List<WikipediaPage> listaDeSimilares2 = filtroPropiedad.getSimilarPages(page3,listaDePaginas);
		List<WikipediaPage> listaDeSimilares3 = filtroPropiedad.getSimilarPages(page5,listaDePaginas);
		
		assertEquals(listaEsperada1,listaDeSimilares1);
		assertEquals(listaEsperada2,listaDeSimilares2);
		assertEquals(listaEsperada3,listaDeSimilares3);
	}


}
