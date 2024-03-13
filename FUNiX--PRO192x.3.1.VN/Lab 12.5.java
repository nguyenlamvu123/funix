import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Entry {
	public static void main(String[] args) {
		PolyLine polyLine = new PolyLine();
		polyLine.appendPoint(new Point(1, 1));
		polyLine.appendPoint(new Point(2, 3));
		polyLine.appendPoint(3, 0);
		polyLine.appendPoint(4, 2);
		System.out.println(polyLine.getLength());
	}
}

class PolyLine {
	private List<Point> points;
	PolyLine() {
		this.points = new ArrayList<Point>();
	}

	PolyLine(List<Point> points) {
		this.points = points;
	}

	void appendPoint(Point point) {
		points.add(point);
	}

	void appendPoint(int x, int y) {
		points.add(new Point(x, y));
	}

	double getLength() {
		double length = 0;
		for (int i = 0; i < points.size() - 1; i++) {
			int x1 = points.get(i).getX();
			int x2 = points.get(i + 1).getX();
			int y1 = points.get(i).getY();
			int y2 = points.get(i + 1).getY();
			double l = Math.sqrt(
				Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)
			);
			length += l;
		}
		return length;
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

	void setY(int y) {
		this.y = y;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}
}