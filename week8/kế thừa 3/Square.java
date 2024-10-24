// package com.khanhtran0111;

public class Square extends Rectangle {

    public Square() {
        super(new Point(0, 0), 0, 0, "black", false);
    }

    public Square(double side) {
        super(new Point(0, 0), side, side, "black", false);
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public String toString() {
        return "Square[topLeft=" + topLeft + ", side=" + getSide() + ", color=" + getColor() + ", filled=" + isFilled() + "]";
    }
}
