public class TestShape {
    public static void main(String[] args) {
        Shape s1 = new Shape();
        System.out.println(s1);  // A Shape with color of green and filled

        Shape s2 = new Shape("blue", false);
        System.out.println(s2);  // A Shape with color of blue and Not filled
    }
}
