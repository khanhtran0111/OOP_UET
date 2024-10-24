// package com.khanhtran0111;

public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
    }

    /**
     * An especially short bit of Javadoc.
     */
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

    public abstract double getArea();

    public abstract double getPerimeter();

    /**
     * An especially short bit of Javadoc.
     */
    public String toString() {
        return "Shape[color="
                + color + ",filled="
                + filled + "]";
    }
}
