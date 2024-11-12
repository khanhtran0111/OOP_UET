public class Triangle implements GeometricObject {
    private Point p1;
    private Point p2;
    private Point p3;

    /**
     * tamgiac.
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

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    /**
     * area.
     */
    public double getArea() {
        return Math.abs(p1.pointX * (p2.pointY - p3.pointY)
                + p2.pointX * (p3.pointY - p1.pointY)
                + p3.pointX * (p1.pointY - p2.pointY)) / 2;
    }

    /**
     * perimeter.
     */
    public double getPerimeter() {
        double x1 = p1.distance(p2);
        double x2 = p1.distance(p3);
        double x3 = p2.distance(p3);
        return x1 + x2 + x3;
    }

    /**
     * lmao.
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