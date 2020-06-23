package tp07.wikipedia;

import java.util.List;
import java.util.Map;

public class WikipediaPageC implements WikipediaPage{

	private String title;
	private List<WikipediaPage> links;
	private Map<String, WikipediaPage> infobox;

	public WikipediaPageC(String title, List<WikipediaPage> links, Map<String, WikipediaPage> infobox) {
		super();
		this.title = title;
		this.links = links;
		this.infobox = infobox;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public List<WikipediaPage> getLinks() {
		return this.links;
	}

	@Override
	public Map<String, WikipediaPage> getInfobox() {
		return this.infobox;
	}

}
