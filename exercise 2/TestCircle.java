public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println(c1); // A Circle with radius=1.0, which is a subclass of A Shape with color of green and filled

        Circle c2 = new Circle(2.0, "blue", false);
        System.out.println(c2); // A Circle with radius=2.0, which is a subclass of A Shape with color of blue and Not filled
    }
}
