import java.util.List;

public class ShapeUtil {
    /**
     * print info.
     */
    public String printInfo(List<GeometricObject> shapes) {
        String circle = "Circle:" + '\n';
        String triangle = "Triangle:" + '\n';
        for (GeometricObject shape : shapes) {
            if (shape instanceof Circle) {
                circle += shape.getInfo() + '\n';
            } else if (shape instanceof Triangle) {
                triangle += shape.getInfo() + '\n';
            }
        }
        return circle + triangle;
    }
}
