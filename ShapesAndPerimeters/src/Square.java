public class Square extends Shape {
    double length, width;
public Square (double length, double width) {
    this.length = length;
    this.width = width;
}

    @Override public double getArea() {
        return length * width;
    }
    @Override public double getPerimeter() {
        return 2 * (length * width);
    }

    /*
    public String toShow() {
        super.toShow(); // adds super and this method together
        System.out.println("Child Show");
        return "Child Show yo";
    }
     */


}