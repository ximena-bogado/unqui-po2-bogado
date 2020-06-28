package tp09.compositeShapeShifter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ShapeShifterTest {

	private IShapeShifter shapeSimple1;
	private IShapeShifter shapeSimple2;
	private IShapeShifter shapeSimple3;
	private IShapeShifter shapeCompuesto12;
	private IShapeShifter shapeCompuesto123;

	@Test
	void testFlatEnUnShapeShifterSimple() {
		shapeSimple1 = new Simple(1);
		
		assertEquals(shapeSimple1, shapeSimple1.flat());
	}
	
	@Test
	void testFlatEnUnShapeCompuesto() {
		shapeSimple1 = new Simple(1);
		shapeSimple2 = new Simple(2);
		shapeSimple3 = new Simple(3);
		
		shapeCompuesto12 = shapeSimple1.compose(shapeSimple2);
		shapeCompuesto123 = shapeCompuesto12.compose(shapeSimple3);
		IShapeShifter shapeFlat = shapeCompuesto123.flat();
		
		assertEquals(1, shapeFlat.deepest());
	}
	
	@Test
	void testprofundidadDos() {
		shapeSimple1 = new Simple(1);
		shapeSimple2 = new Simple(2);
		shapeSimple3 = new Simple(3);
		
		shapeCompuesto12 = shapeSimple1.compose(shapeSimple2);
		shapeCompuesto123 = shapeCompuesto12.compose(shapeSimple3);
		
		assertEquals(2, shapeCompuesto123.deepest());
	}

}
