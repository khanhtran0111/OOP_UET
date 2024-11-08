package com.khanhtran0111;

public class Circle implements GeometricObject {
    public static final double PI = 3.14;
    private Point center;
    private double radius;

    /**
     * add comment.
     */
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * lmao.
     */
    public double getArea() {
        return (PI * PI * radius);
    }

    /**
     * lmao.
     */
    public double getPerimeter() {
        return (2 * PI * radius);
    }

    /**
     * lmao.
     */
    public String getInfo() {
        return "Circle[("
                + String.format("%.2f", center.pointX) + ","
                + String.format("%.2f", center.pointY) + "),r="
                + String.format("%.2f", radius) + "]";
    }
}
