import java.awt.*;
import java.util.Vector;

public class Polygon extends Deq implements Figure {
    private double s, p;
    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }
    public Polygon(R2Point a, R2Point b, R2Point c) {
        pushFront(b);
        if (b.light(a, c)) {
            pushFront(a); pushBack(c);
        } else {
            pushFront(c); pushBack(a);
        }
        p = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }
    public double perimeter() {
        return p;
    }
    public double area() {
        return s;
    }
    public Figure add(R2Point t) {
        int i;
// Ищем освещенные ребра, просматривая их одно за другим.
        for (i=length(); i>0 && !t.light(back(),front()); i--)
            pushBack(popFront());
// УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
// либо освещенных ребер нет совсем.
        if (i>0) {
            R2Point x;
            grow(back(), front(), t);
// Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront())
            {
                R2Point.decalc(x);
                grow(x, front(), t);
            }
            pushFront(x);
// Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
            {
                R2Point.decalc(x);
                grow(back(), x, t);
            }
            pushBack(x);
// Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
            R2Point.calc(t);
        }
        return this;
    }
    public void draw(Graphics g)
    {
        for (int i=0; i<length(); i++)
        {
            g.drawLine((int)front().getX(), (int)front().getY(), (int)back().getX(), (int)back().getY());
            pushBack(popFront());
        }
    }
    public int calc()
    {
        /*double x1 = Rectangle.point1.getX(); double y1 = Rectangle.point1.getY();
        double x2 = Rectangle.point2.getX(); double y2 = Rectangle.point2.getY();
        R2Point points[] = new R2Point[] { new R2Point(x1,y1), new R2Point(x2,y1), new R2Point(x2,y2), new R2Point(x1,y2), new R2Point(x1,y1) };
        int k[] = new int[] { 0, 0, 0, 0 };
        for (int i = 0; i < length(); i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if ((R2Point.area(points[j], points[j+1], front()) == 0) && front().inside(points[j], points[j+1]))
                {
                    if (k[j] == 0)
                    {
                        k[j]++;
                    }
                }
            }
            pushBack(popFront());
        }
        return k[0] + k[1] + k[2] + k[3];*/
        return Rectangle.KOL;
    }
}
