package com.khanhtran0111;

public class Triangle implements GeometricObject{
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * lmao.
     */
    public Triangle(Point p1, Point p2, Point p3) throws RuntimeException {
        if ((p1.distance(p2) + p2.distance(p3)) > p3.distance(p1)
                && (p2.distance(p3) + p3.distance(p1)) > p1.distance(p2)
                && (p3.distance(p1) + p1.distance(p2)) > p2.distance(p3)) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
        } else {
            throw new RuntimeException();
        }
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    /**
     * perimeter.
     */
    public double getPerimeter() {
        double x1 = p1.distance(p2);
        double x2 = p2.distance(p3);
        double x3 = p3.distance(p1);
        return x1 + x2 + x3;
    }

    /**
     * area.
     */
    public String getInfo() {
        return "Triangle[(" + String.format("%.2f", p1.pointX) + ","
                + String.format("%.2f", p1.pointY) + "),"
                + "(" + String.format("%.2f", p2.pointX) + ","
                + String.format("%.2f", p2.pointY) + "),"
                + "(" + String.format("%.2f", p3.pointX) + ","
                + String.format("%.2f", p3.pointY) + ")]";
    }
}
