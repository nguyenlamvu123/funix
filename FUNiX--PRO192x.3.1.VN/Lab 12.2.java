import java.lang.Math;

public class Entry {
	public static void main(String[] args) {
		Point vertice1 = new Point(1, 3);
		Point vertice2 = new Point(2, 3);
		Point vertice3 = new Point(4, 2);
		Triangle triangle1 = new Triangle(vertice1, vertice2, vertice3);
		Triangle triangle2 = new Triangle(4, 5, 2, 6, 3, 7);
		System.out.println(triangle1.getPerimeter());
		System.out.println(triangle2.getPerimeter());
	}
}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int x) {
        this.y = x;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}

class Triangle {
    private Point vertice1;
    private Point vertice2;
    private Point vertice3;

    Triangle(Point vertice1, Point vertice2, Point vertice3) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.vertice3 = vertice3;
    }

    Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.vertice1 = new Point(x1, y1);
        this.vertice2 = new Point(x2, y2);
        this.vertice3 = new Point(x3, y3);
    }

    double getLength(Point dau, Point cuoi) {
        return Math.sqrt(Math.pow(dau.getX() - cuoi.getX(), 2) + Math.pow(dau.getY() - cuoi.getY(), 2));
    }

    double getPerimeter() {
        return getLength(vertice1, vertice2) + getLength(vertice3, vertice2) + getLength(vertice1, vertice3);
    }
}
