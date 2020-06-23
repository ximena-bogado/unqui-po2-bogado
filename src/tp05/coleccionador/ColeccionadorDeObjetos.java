package tp05.coleccionador;

import java.util.Collection;
import java.util.List;

public class ColeccionadorDeObjetos {
	
	public Object getFirstFrom(List<Object> collection) {
		return collection.get(0);
	}
	
	public void addLast (Object element, List<Object> collection) {
		
		collection.add(element);
	}
	
	public List<Object> getSubCollection (List<Object> collection, int from, int to) {
		return collection.subList(from,to);
	}
	
	public Boolean containsElement (Collection<Object> collection, Object element) {
		return collection.contains(element);
	}

}
