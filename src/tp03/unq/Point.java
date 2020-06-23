package tp03.unq;

public class Point {
	private float x;
	private float y;
	
	
	public Point(float x, float y) {
		this.setXY(x,y);
	}
	
	public Point() {
		this.setXY(0,0);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void setXY (float x, float y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Point sumarseConOtroPunto (Point punto) {
		float x = this.getX() + punto.getX();
		float y = this.getY() + punto.getY();
		
		return  new Point(x,y);
	}

}
