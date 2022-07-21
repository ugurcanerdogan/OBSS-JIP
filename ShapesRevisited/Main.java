package ShapesRevisited;

public class Main {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Shape rectangle = new Rectangle("Red", 5, 10);
        Shape circle = new Circle("Blue", 10);

        pen.drawShape(rectangle);
        pen.drawShape(circle);

        rectangle.draw();
        circle.draw();

        pen.changeColor("Green", rectangle);
        pen.changeColor("Magenta", circle);

    }
}