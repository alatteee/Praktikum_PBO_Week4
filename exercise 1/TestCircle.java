public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.0, "blue"); // pakai constructor baru
        System.out.println(c1.toString());   // Circle[radius=2.0, color=blue]

        c1.setColor("green");                // pakai setter baru
        System.out.println("New color: " + c1.getColor());
    }
}
