package com.khanhtran0111;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return height * super.getArea();
    }

    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ",height=" + height + "]";
    }

    @Override
    public double getArea() {
        double baseArea = super.getArea();
        double ra = super.getRadius();
        double lateralArea = 2 * PI * ra * height;
        return 2 * baseArea + lateralArea;
    }
}