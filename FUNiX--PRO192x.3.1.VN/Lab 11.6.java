public class Entry {
	public static void main(String[] args) {
		IShape[] shapes = new IShape[3];
		shapes[0] = new Rectangle(3.4, 5.3);
		shapes[1] = new Circle(5.5);
		shapes[2] = new Rectangle(7.4, 4.3);
		for (int i = 0; i < 3; i++) {
			System.out.println("Area of shapes[" + i + "]: " + shapes[i].getArea());
			System.out.println("Perimeter of shapes[" + i + "]: " + shapes[i].getPerimeter());
		}
	}
}


public interface IShape {
	double getArea();
	double getPerimeter();
}


class Rectangle implements IShape {
	private double length;
	private double width;

    Rectangle(double length, double width) {
	super()
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }
}


class Circle implements IShape {
    private double radius;

    Circle(double radius) {
	    super();
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * 3.14;
    }

    @Override
    public double getPerimeter() {
        return 3.14 * 2 * radius;
    }
}
