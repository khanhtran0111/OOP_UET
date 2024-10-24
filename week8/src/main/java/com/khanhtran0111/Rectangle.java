package com.khanhtran0111;
import java.awt.*;

public class Rectangle extends Shape {
    protected double width;
    protected double length;
    protected Point topLeft = new Point(0, 0);

    // Default constructor
    public Rectangle() {}

    // Constructor with width and length
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    // Constructor with all parameters
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
        this.topLeft = topLeft;
    }

    // Getter for width
    public double getWidth() {
        return width;
    }

    // Setter for width
    public void setWidth(double width) {
        this.width = width;
    }

    // Getter for length
    public double getLength() {
        return length;
    }

    // Setter for length
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public void move() {
        topLeft.setPointX(topLeft.getPointX() + velocityX); // Update X position
        topLeft.setPointY(topLeft.getPointY() + velocityY); // Update Y position
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.decode(color)); // Set color
        g.drawRect((int) topLeft.getPointX(), (int) topLeft.getPointY(), (int) width, (int) length);
    }

    @Override
    public String toString() {
        return "Rectangle[topLeft=" + topLeft + ", width=" + width + ", length=" + length + "]";
    }
}
