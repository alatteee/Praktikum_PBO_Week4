public class Cylinder extends Circle {
    private double height;

    // Constructor with default color, radius and height
    public Cylinder() {
        super(); // call superclass no-arg constructor Circle()
        height = 1.0;
    }

    // Constructor with default radius, color but given height
    public Cylinder(double height) {
        super(); // call superclass no-arg constructor Circle()
        this.height = height;
    }

    // Constructor with default color, but given radius, height
    public Cylinder(double radius, double height) {
        super(radius); // call superclass constructor Circle(r)
        this.height = height;
    }

    // Constructor dengan radius, height, dan color
    public Cylinder(double radius, double height, String color) {
        super(radius, color); // panggil constructor Circle(radius, color)
        this.height = height;
    }

    // A public method for retrieving the height
    public double getHeight() {
        return height;
    }

    //Task 1.2 → Override getArea()
    @Override
    public double getArea() {
        // surface area = 2πrh + 2πr²
        return 2 * Math.PI * getRadius() * height   // luas selimut
             + 2 * super.getArea();                 // 2x luas alas (Circle)
    }

    // Task 1.2 → Fix getVolume()
    public double getVolume() {
        // volume = luas alas × tinggi
        return super.getArea() * height; // pakai getArea() dari Circle
    }

    //task 1.3
    @Override
    public String toString() {
        return "Cylinder: subclass of " + super.toString()  // panggil toString dari Circle
            + " height=" + height;
    }

}
