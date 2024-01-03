package week6.day5;

public class Circle implements Shape{
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        double area = radius * radius *3.14;
        return area;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }
}
