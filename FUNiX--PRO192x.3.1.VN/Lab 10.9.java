import java.lang.Math;


public class Entry {
	public static void main(String[] args) {
		Point p1 = new Point(1.5, 6.7);
		Point p2 = new Point(2.8, 3.2);
		System.out.println(p1.distance(p2));
		System.out.println(p1.distance(2.34, 7.8));
	}
}


class Point {
    private double x;
    private double y;

    Point() {}

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double id) {
        this.x = id;
    }

    public double getX() {
        return x;
    }

    public void setY(double id) {
        this.y = id;
    }

    public double getY() {
        return y;
    }

    public double distance(double x, double y) {
    	double dista = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return dista;
    }

    public double distance(Point xx) {
    	double dista = Math.sqrt(Math.pow(xx.x - this.x, 2) + Math.pow(xx.y - this.y, 2));
        return dista;
    }
}
