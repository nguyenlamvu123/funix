class Rectangle {
    private double length;
    private double width;

    public Rectangle() {}

    public Rectangle(double length, double width) {
       this.length = length;
       this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double length) {
        this.width = length;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return (length + width) * 2;
    }
}
