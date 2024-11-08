package com.khanhtran0111;

public class Point {
    public double pointX;
    public double pointY;

    /**
     * khai bao point.
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
     * lmao.
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(pointX - other.pointX, 2)
                + Math.pow(pointY - other.pointY, 2));
    }
}
