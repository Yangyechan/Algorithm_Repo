package week6.day5;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        Shape circle = new Circle(3.5);

        double area1 = rectangle.calculateArea();
        double perimeter1 = rectangle.calculatePerimeter();

        double area2 = circle.calculateArea();
        double perimeter2 = circle.calculatePerimeter();

        System.out.println("사각형의 넓이: " + area1);
        System.out.println("사각형의 둘레: " + perimeter1);
        System.out.println("원의 넓이: " + area2);
        System.out.println("원의 둘레: " + perimeter2);
    }
}
