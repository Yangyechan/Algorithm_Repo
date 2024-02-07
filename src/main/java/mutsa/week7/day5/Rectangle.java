package mutsa.week7.day5;

public class Rectangle implements Shape{
    private double width;
    private double length;
    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    @Override
    public double calculateArea() {
        return width * length;
    }

    @Override
    public double calculatePerimeter() {
        return (width + length) * 2;
    }
}
