// package com.khanhtran0111;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
    protected double radius;
    protected Point center = new Point(0, 0);

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

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
    public void move() {
        center.setPointX(center.getPointX() + velocityX);
        center.setPointY(center.getPointY() + velocityY);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.decode(color));
        g.drawOval((int) center.getPointX(), (int) center.getPointY(), (int) radius * 2, (int) radius * 2);
    }

    @Override
    public String toString() {
        return "Circle[center=" + center + ", radius=" + radius + "]";
    }
}
