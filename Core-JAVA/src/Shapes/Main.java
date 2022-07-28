package Shapes;

public class Main {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Rectangle rectangle = new Rectangle(5, 10, "Red");
        Circle circle = new Circle(10, "Blue");

        pen.drawRectangle(rectangle);
        pen.drawCircle(circle);

        pen.changeColorRectangle("Green", rectangle);
        pen.changeColorCircle("Magenta", circle);

    }
}