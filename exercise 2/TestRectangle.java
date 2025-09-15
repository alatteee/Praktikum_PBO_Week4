public class TestRectangle {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        System.out.println(r1);

        Rectangle r2 = new Rectangle(3.0, 4.0);
        System.out.println(r2);

        Rectangle r3 = new Rectangle(2.0, 5.0, "yellow", true);
        System.out.println(r3);
        System.out.println("area=" + r3.getArea() + ", perimeter=" + r3.getPerimeter());
    }
}
