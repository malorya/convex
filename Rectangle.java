import java.awt.*;

public class Rectangle
{
    private Figure fig;
    public static Polygon P;
    public static R2Point point1,point2;
    public static int KOL = -8;
    public Rectangle(R2Point point1, R2Point point2)
    {
        fig = new Void();
        this.point1 = point1;
        this.point2 = point2;
        R2Point point3 = new R2Point(point1.getX(), point2.getY());
        R2Point point4 = new R2Point(point2.getX(), point1.getY());
        fig = fig.add(point1);
        fig = fig.add(point2);
        fig = fig.add(point3);
        fig = fig.add(point4);
        P = (Polygon)fig;
    }
    public void draw(Graphics2D g)
    {
        P.draw(g);
    }
}
