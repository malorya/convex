import java.awt.*;

public interface Figure {
    public double perimeter();
    public double area();
    public Figure add(R2Point p);
    public void draw(Graphics2D g);
    public int calc();
}
