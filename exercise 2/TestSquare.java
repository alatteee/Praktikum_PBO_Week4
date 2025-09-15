public class TestSquare {
    public static void main(String[] args) {
        Square s1 = new Square();
        System.out.println(s1);

        Square s2 = new Square(5.0);
        System.out.println(s2);

        Square s3 = new Square(4.0, "purple", false);
        System.out.println(s3);

        // Tes setSide
        s3.setSide(7.0);
        System.out.println("After setSide: " + s3);

        // Tes setWidth (harusnya ikut setLength juga)
        s3.setWidth(10.0);
        System.out.println("After setWidth: " + s3);
    }
}
