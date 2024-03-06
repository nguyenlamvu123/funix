import java.lang.Math;

public class Entry {
	public static void main(String[] args) {
		Point begin = new Point(1, 1);
		Point end = new Point(2, 2);
		Line line1 = new Line(begin, end);
		System.out.println(line1.getLength());

		Line line2 = new Line(2, 3, 5, 4);
		System.out.println(line2.getLength());
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

class Line {
    private Point begin;
    private Point end;

    Line(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }

    Line(int x1, int y1, int x2, int y2) {
        this.begin = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    void setBegin(Point begin) {
        this.begin = begin;
    }

    Point getBegin() {
        return begin;
    }

    void setEnd(Point begin) {
        this.end = begin;
    }

    Point getEnd() {
        return end;
    }

    double getLength() {
        return Math.sqrt(Math.pow(begin.getX() - end.getX(), 2) + Math.pow(begin.getY() - end.getY(), 2));
    }
}
