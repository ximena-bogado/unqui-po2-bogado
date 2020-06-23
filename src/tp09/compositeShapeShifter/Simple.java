package tp09.compositeShapeShifter;

import java.util.ArrayList;
import java.util.List;

public class Simple implements IShapeShifter{

	private Integer valor;

	public Simple(Integer valor) {
		this.valor = valor;
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
		return 0;
	}

	@Override
	public IShapeShifter flat() {
		
		return this;
	}

	@Override
	public List<Integer> values() {
		List<Integer> values = new ArrayList<Integer>();
		values.add(valor);
		
		return values;
	}

}
