package Shapes;

public class Pen {

    public void drawRectangle(Rectangle r) {
        int area = r.getHeight() * r.getWidth();
        System.out.println("Rectangle's area : " + area);
    }

    public void drawCircle(Circle c) {
        double area = Math.PI * Math.pow(c.getRadius(), 2);
        System.out.println("Circle's area : " + area);
    }

    public void changeColorRectangle(String color, Rectangle r) {
        r.setColor(color);
        System.out.println("Rectangle's new color : " + r.getColor());
    }

    public void changeColorCircle(String color, Circle c) {
        c.setColor(color);
        System.out.println("Circle's new color : " + c.getColor());
    }
}
