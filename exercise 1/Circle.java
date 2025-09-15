/**
* The Circle class models a circle with a radius and color.
*/
public class Circle {
    private double radius;
    private String color;

    // Constructor default
    public Circle() {
        radius = 1.0;
        color = "red";
    }

    // Constructor dengan radius
    public Circle(double r) {
        radius = r;
        color = "red";
    }

    // Constructor baru (Task 1.1) dengan radius & color
    public Circle(double r, String c) {
        radius = r;
        color = c;
    }

    // Getter & setter radius
    public double getRadius() {
        return radius;
    }
    public void setRadius(double r) {
        radius = r;
    }

    // Getter & setter color (Task 1.1)
    public String getColor() {
        return color;
    }
    public void setColor(String c) {
        color = c;
    }

    // Hitung luas lingkaran
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // toString
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}
