package ShapesRevisited;

public class Circle extends Shape {
    private int radius;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + ", color='" + color + '\'' + '}';
    }

    @Override
    public void draw() {
        double area = Math.PI * Math.pow(this.radius, 2);
        System.out.println("Circle's method called...");
        System.out.println("Circle's area : " + area);
    }
}
