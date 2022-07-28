package ShapesRevisited;

public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(String color, int height, int width) {
        super(color);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "height=" + height + ", width=" + width + ", color='" + color + '\'' + '}';
    }

    @Override
    public void draw() {
        int area = this.height * this.width;
        System.out.println("Rectangle's method called...");
        System.out.println("Rectangle's area : " + area);
    }
}
