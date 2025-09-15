// TestAll.java
public class TestAll {
    public static void main(String[] args) {
        System.out.println("=== TEST SHAPE ===");
        Shape s1 = new Shape();
        Shape s2 = new Shape("blue", false);
        System.out.println(s1); // toString()
        System.out.println(s2);
        s2.setColor("yellow");
        s2.setFilled(true);
        System.out.println("After set: " + s2.getColor() + ", filled=" + s2.isFilled());

        System.out.println("\n=== TEST CIRCLE ===");
        Circle c1 = new Circle();                    // no-arg
        Circle c2 = new Circle(2.5);                 // radius
        Circle c3 = new Circle(3.0, "red", false);   // radius,color,filled
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println("c3 area=" + c3.getArea() + ", perimeter=" + c3.getPerimeter());

        System.out.println("\n=== TEST RECTANGLE ===");
        Rectangle r1 = new Rectangle();                          // no-arg
        Rectangle r2 = new Rectangle(3.0, 4.0);                  // w,l
        Rectangle r3 = new Rectangle(2.0, 5.0, "green", true);   // w,l,color,filled
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println("r3 area=" + r3.getArea() + ", perimeter=" + r3.getPerimeter());

        System.out.println("\n=== TEST SQUARE ===");
        Square q1 = new Square();                         // side=1
        Square q2 = new Square(5.0);                      // side
        Square q3 = new Square(4.0, "purple", false);     // side,color,filled
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
        // cek konsistensi sisi saat diubah
        q3.setSide(7.0);
        System.out.println("After setSide(7): " + q3 + " (side=" + q3.getSide() + ")");
        q3.setWidth(10.0); // harus ikutan setLength juga
        System.out.println("After setWidth(10): " + q3 + " (side=" + q3.getSide() + ")");
    }
}
