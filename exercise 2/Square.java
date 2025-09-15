public class Square extends Rectangle {

    // Constructor default
    public Square() {
        super(1.0, 1.0);
    }

    // Constructor dengan side
    public Square(double side) {
        super(side, side);
    }

    // Constructor dengan side, color, filled
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    // Getter & Setter
    public double getSide() {
        return getWidth(); // karena width = length
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double side) {
        setSide(side);
    }

    @Override
    public void setLength(double side) {
        setSide(side);
    }

    @Override
    public String toString() {
        return "A Square with side=" + getSide()
             + ", which is a subclass of " + super.toString();
    }
}
