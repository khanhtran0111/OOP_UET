// package com.khanhtran0111;
import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;

    /**
     * An especially short bit of Javadoc.
     */
    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public double distance(Point p) {
        double pointx = Math.pow(pointX - p.pointX, 2);
        double pointy = Math.pow(pointY - p.pointY, 2);
        return Math.sqrt(pointx + pointy);
    }

    /**
     * An especially short bit of Javadoc.
     */
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point p = (Point) obj;
            if (pointX == p.pointX && pointY == p.pointY) {
                return true;
            }
        }
        return false;
    }

    /**
     * An especially short bit of Javadoc.
     */
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    /**
     * An especially short bit of Javadoc.
     */
    public String toString() {
        return "(" + (double) Math.round(pointX * 10) / 10
                + "," + (double) Math.round(pointY * 10) / 10 + ")";
    }
}