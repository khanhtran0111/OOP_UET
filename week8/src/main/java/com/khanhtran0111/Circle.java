package com.khanhtran0111;

public class Circle extends Shape {
    protected double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        super.color = color;
        super.filled = filled;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public double getArea() {
        return Math.PI * radius * radius;
    }


    public double getPerimeter() {
        return Math.PI * 2.0 * radius;
    }

    @Override
    public String toString() {
        return "Circle[" + "radius=" + radius
                + ",color=" + color
                + ",filled=" + filled
                + ']';
    }
}