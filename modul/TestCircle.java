public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();        // default: radius=1.0, color="red"
        System.out.println(c1.toString()); // pakai toString bawaan modul
        System.out.println("radius=" + c1.getRadius());
        System.out.println("area=" + c1.getArea());
    }
}
