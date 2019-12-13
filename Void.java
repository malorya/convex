import java.awt.*;

public class Void implements Figure {
    public double perimeter() {
        return 0.0;
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point p)
    {
        R2Point.calc(p);
        return new Point(p);
    }
    public void draw(Graphics2D g)
    {

    }
    public int calc()
    {
        return Rectangle.KOL;
    }
}
