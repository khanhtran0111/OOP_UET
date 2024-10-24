// package com.khanhtran0111;

import java.util.Objects;

public class Rectangle extends Shape {
    protected double width;
    protected double length;
    protected Point topLeft = new Point(0, 0);

    /**
     * An especially short bit of Javadoc.
     */
    public Rectangle() {
    }

    ;

    /**
     * An especially short bit of Javadoc.
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point point) {
        this.topLeft = point;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            if (topLeft.equals(rectangle.topLeft)
                    && (width - rectangle.width) == 0
                    && (length - rectangle.length) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width, topLeft);
    }

    /**
     * An especially short bit of Javadoc.
     */
    public String toString() {
        String color = getColor();
        boolean filled = isFilled();
        String s = topLeft.toString();
        return "Rectangle[topLeft=" + s
                + ",width=" + (double) Math.round(width * 10) / 10
                + ",length=" + (double) Math.round(length * 10) / 10
                + ",color=" + color
                + ",filled=" + filled + "]";
    }
}