public class Rectangle extends Shape {
    double length, width;

    public Rectangle(double length, double width) { //constructor
        this.width = width;
        this.length = length;
    }
    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }
}
