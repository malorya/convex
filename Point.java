import java.awt.*;

public class Point implements Figure {
    private R2Point p;
    public Point(R2Point p) {
        this.p = p;
    }
    public double perimeter() {
        return 0.0;
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point q) {
        if (!R2Point.equal(p,q)) return new Segment(p, q);
        else return this;
    }
    public void draw(Graphics g)
    {
        g.fillOval((int)p.getX(), (int)p.getY(), 1, 1);
    }
    public int calc(Rectangle Rect)
    {
        int k[] = new int[] { 0, 0, 0, 0 };
        double x1 = Rect.point1.getX(); double y1 = Rect.point1.getY();
        double x2 = Rect.point2.getX(); double y2 = Rect.point2.getY();
        R2Point points[] = new R2Point[] { new R2Point(x1,y1), new R2Point(x2,y1), new R2Point(x2,y2), new R2Point(x1,y2), new R2Point(x1,y1) };
        for (int j = 0; j < 4; j++)
        {
            if ((R2Point.area(points[j], points[j+1], p) == 0) && p.inside(points[j], points[j+1]))
            {
                if (k[j] == 0)
                {
                    k[j]++;
                }
            }
        }
        return k[0] + k[1]+ k[2] + k[3];
    }
}
