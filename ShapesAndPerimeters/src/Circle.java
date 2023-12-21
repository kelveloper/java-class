public class Circle extends Shape {
    double radius;
    /*
    public Circle( double radius) {
        this.radius = radius;
    } DON'T NEED IT, IF YOU WANT TO IN THE MAIN CLASS
    */
    @Override public double getArea () {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
