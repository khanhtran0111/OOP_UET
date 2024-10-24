// package com.khanhtran0111;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        setLength(side);
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Square(double side, String color, boolean filled) {
        setLength(side);
        super.setColor(color);
        super.setFilled(filled);
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Square(Point topLeft, double side, String color, boolean filled) {
        setLength(side);
        super.setColor(color);
        super.setFilled(filled);
        super.setTopLeft(topLeft);
    }

    public void setSide(double side) {
        setLength(side);
    }

    public double getSide() {
        return getLength();
    }

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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        Point topLeft = super.getTopLeft();
        return "Square[topLeft=" + topLeft
                + ",side=" + (double) Math.round(getSide() * 10) / 10
                + ",color=" + getColor()
                + ",filled=" + isFilled() + "]";
    }
}