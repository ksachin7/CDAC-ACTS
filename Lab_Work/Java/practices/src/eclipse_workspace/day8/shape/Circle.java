package eclipse_workspace.day8.shape;

public class Circle extends Shape {
	private float radius;
	

	public Circle(float radius) {
		this.radius=radius;
	}

//	@Override
//	public float calculateArea(float l, float b) {
//		radius= l;
//		return 3.14 * radius * radius;
//	}
//	
//	@Override
//	public float calculatePerimeter(float l, float b) {
//		return 2 * 3.14 * radius;
//	}
	
	@Override
	public float calculateArea() {
		return (float) (3.14 * radius * radius);
	}

	@Override
	public float calculatePerimeter() {
		return (float) (2 * 3.14 * radius);
	}
	
	void draw() {
		System.out.println("drawing...");
	}
}
