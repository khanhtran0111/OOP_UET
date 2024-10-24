package com.khanhtran0111;

import java.awt.Graphics;

public abstract class Shape {
    protected String color;
    protected boolean filled;
    protected double velocityX = 1.0;  // Movement speed on X-axis
    protected double velocityY = 1.0;  // Movement speed on Y-axis

    public Shape() {}

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Abstract methods to get area, perimeter, and to draw shape
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void draw(Graphics g); // Added abstract method for drawing
    public abstract void move();            // Abstract method for movement

    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + "]";
    }
}
