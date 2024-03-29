import java.awt.*;

public class Segment implements Figure {
    private R2Point p, q;
    public Segment(R2Point p, R2Point q) {
        this.p = p; this.q = q;
    }
    public double perimeter() {
        return 2.0 * R2Point.dist(p, q);
    }
    public double area() {
        return 0.0;
    }
    public Figure add(R2Point r) {
        if (R2Point.isTriangle(p, q, r))
        {
            R2Point.calc(r);
            return new Polygon(p, q, r);
        }
        if (q.inside(p, r))
        {
            R2Point.decalc(q);
            q = r;
            R2Point.calc(q);
            return this;
        }
        if (p.inside(r, q))
        {
            R2Point.decalc(p);
            p = r;
            R2Point.calc(p);
            return this;
        }
        return this;
    }
    public void draw(Graphics2D g)
    {
        g.drawLine((int)p.getX(),(int)p.getY(),(int)q.getX(),(int)q.getY());
    }
    public int calc()
    {
        /*int k[] = new int[] { 0, 0, 0, 0 };
        double x1 = Rectangle.point1.getX(); double y1 = Rectangle.point1.getY();
        double x2 = Rectangle.point2.getX(); double y2 = Rectangle.point2.getY();
        R2Point points[] = new R2Point[] { new R2Point(x1,y1), new R2Point(x2,y1), new R2Point(x2,y2), new R2Point(x1,y2), new R2Point(x1,y1) };
        R2Point points1[] = new R2Point[] { p, p, q, q };
        for (int j = 0; j < 4; j++)
        {
            if ((R2Point.area(points[j], points[j+1], points1[j]) == 0) && points1[j].inside(points[j], points[j+1]))
            {
                if (k[j] == 0)
                {
                    k[j]++;
                }
            }
        }
        return k[0] + k[1]+ k[2] + k[3];*/
        return Rectangle.KOL;
    }
}
