package com.khanhtran0111;

public class Square extends Rectangle {

    public Square() {
        super(new Point(0, 0), 0, 0, "black", false); // Default constructor
    }

    public Square(double side) {
        super(new Point(0, 0), side, side, "black", false); // Constructor with side
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled); // Call Rectangle constructor
    }

    public double getSide() {
        return getWidth(); // For a square, width and length are the same
    }

    public void setSide(double side) {
        setWidth(side); // Set both width and length to the same value
        setLength(side);
    }

    @Override
    public String toString() {
        return "Square[topLeft=" + topLeft + ", side=" + getSide() + ", color=" + getColor() + ", filled=" + isFilled() + "]";
    }
}
