package ShapesRevisited;

public class Pen {

    public void drawShape(Shape shape) {
        if (shape instanceof Rectangle) {
            int area = ((Rectangle) shape).getHeight() * ((Rectangle) shape).getWidth();
            System.out.println("Pen's method called...");
            System.out.println("Rectangle's area : " + area);
        } else {
            double area = Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
            System.out.println("Pen's method called...");
            System.out.println("Circle's area : " + area);
        }
    }

    public void otherDrawShapeMethod(Shape shape) {
        shape.draw();
    }

    public void changeColor(String color, Shape shape) {
        shape.setColor(color);
        System.out.println("Shape's new color : " + shape.getColor());
    }

}
