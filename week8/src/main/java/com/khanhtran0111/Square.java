package com.khanhtran0111;

public class Square extends Rectangle {
    @Override
    public void setLength(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    public Square() {

    }

    public Square(double side) {
        super(side, side);
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Square(double side, String color, boolean filled) {
        super(side, side);
        super.color = color;
        super.filled = filled;
    }

    public double getSide() {
        return getLength();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public double getArea() {
        return getSide() * getSide();
    }

    @Override
    public double getPerimeter() {
        return getSide() * 4;
    }

    /**
     * An especially short bit of Javadoc.
     */
    @Override
    public String toString() {
        return "Square[" + "side=" + getSide()
                + ",color=" + color
                + ",filled=" + filled
                + ']';
    }
}