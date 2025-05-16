package eclipse_workspace.day8.shape;

public class ShapeTester {

	public ShapeTester() {}

	public static void main(String[] args) {
		Shape c = new Circle(3);
		Shape r= new Rectangle(5, 4);
//		
//		System.out.println("Area of "+c.getClass()+" is:"+c.calculateArea());
//		System.out.println("Perimeter of "+c.getClass()+" is:"+c.calculatePerimeter());
//		
//
//		System.out.println("Area of rectangle"+r.getClass()+" is:"+c.calculateArea());
//		System.out.println("Perimeter of rectangle"+r.getClass()+" is:"+c.calculatePerimeter());
		
		
		System.out.println("Area of circle"+" is: "+c.calculateArea());
		System.out.println("Perimeter of circle"+" is: "+c.calculatePerimeter());

		System.out.println("Area of rectangle"+" is: "+r.calculateArea());
		System.out.println("Perimeter of rectangle"+" is: "+r.calculatePerimeter());
		
		((Circle) c).draw();
	}
}
