public class Triangle extends Shape {
    double base, height, a, b, c;

    @Override
    public double getArea() {
        return base * height * (1 / 2);
    }

    @Override
    public double getPerimeter() {
        return a * b * c;
    }
}
