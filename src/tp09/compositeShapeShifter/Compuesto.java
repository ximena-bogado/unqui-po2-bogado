package tp09.compositeShapeShifter;

import java.util.ArrayList;
import java.util.List;

public class Compuesto implements IShapeShifter{

	private List<IShapeShifter> componentes;
	
	public Compuesto() {
		componentes = new ArrayList<IShapeShifter>();
	}

	@Override
	public IShapeShifter compose(IShapeShifter shape) {
		Compuesto compuesto = new Compuesto();
		compuesto.agregar(this);
		compuesto.agregar(shape);
		
		return compuesto;
	}

	@Override
	public Integer deepest() {
		Integer contador = 1;
		for (IShapeShifter shape: componentes) {
			contador += shape.deepest();
		}
		return contador;
	}

	@Override
	public IShapeShifter flat() {
		Compuesto nuevoShape = new Compuesto();
		List<Integer> valores = this.values();
		for (Integer valor: valores) {
			nuevoShape.agregar(new Simple(valor));
		}
		return nuevoShape;
	}

	@Override
	public List<Integer> values() {
		List<Integer> values = new ArrayList<Integer>();
		
		for (IShapeShifter shape: componentes) {
			values.addAll(shape.values());
		}
		
		return values;
	}
	
	public void agregar(IShapeShifter shape) {
		componentes.add(shape);
	}

}
