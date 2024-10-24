// package com.khanhtran0111;
import java.util.Objects;

public class Circle extends Shape {
    protected double radius;
    protected Point center = new Point(0, 0);

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
        this.center = center;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point point) {
        this.center = point;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle circle = (Circle) obj;
            if (center.equals(circle.center) && (radius - circle.radius) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, center);
    }

    /**
     * An especially short bit of Javadoc.
     */
    public String toString() {
        String color = getColor();
        boolean filled = isFilled();
        String s = center.toString();
        return "Circle[center=" + s
                + ",radius=" + (double) Math.round(radius * 10) / 10
                + ",color=" + color + ",filled=" + filled + "]";
    }
}