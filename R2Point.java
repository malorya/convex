import java.util.Scanner;

public class R2Point {
    private double x, y;
    public R2Point(double x, double y) {
        this.x = x; this.y = y;
    }
    public R2Point() throws Exception {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
    }
    public static double dist(R2Point a, R2Point b) {
        return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
    }
    public static double area(R2Point a, R2Point b, R2Point c) {
        return 0.5*((a.x-c.x)*(b.y-c.y)-(a.y-c.y)*(b.x-c.x));
    }

    public static boolean equal(R2Point a, R2Point b) {
        return a.x==b.x && a.y==b.y;
    }
    public static boolean isTriangle(R2Point a, R2Point b, R2Point c) {
        return area(a, b, c) != 0.0;
    }
    public boolean inside(R2Point a, R2Point b) {
        return (a.x <= x && x <= b.x || a.x >= x && x >= b.x) && (a.y <= y && y <= b.y || a.y >= y && y >= b.y);
    }
    public boolean light(R2Point a, R2Point b) {
        double s = area(a, b, this);
        return s < 0.0 || ( s == 0.0 && ! inside(a, b));
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public static int calc(R2Point point)
    {
        int k[] = new int[] { 0, 0, 0, 0 };
        double x1 = Rectangle.point1.getX(); double y1 = Rectangle.point1.getY();
        double x2 = Rectangle.point2.getX(); double y2 = Rectangle.point2.getY();
        R2Point points[] = new R2Point[] { new R2Point(x1,y1), new R2Point(x2,y1), new R2Point(x2,y2), new R2Point(x1,y2), new R2Point(x1,y1) };
        for (int j = 0; j < 4; j++)
        {
            if ((R2Point.area(points[j], points[j+1], point) == 0) && point.inside(points[j], points[j+1]))
            {
                if (k[j] == 0)
                {
                    k[j]++;
                }
            }
        }
        Rectangle.KOL += k[0] + k[1]+ k[2] + k[3];
        return Rectangle.KOL;
    }
    public static int decalc(R2Point point)
    {
        int k[] = new int[] { 0, 0, 0, 0 };
        double x1 = Rectangle.point1.getX(); double y1 = Rectangle.point1.getY();
        double x2 = Rectangle.point2.getX(); double y2 = Rectangle.point2.getY();
        R2Point points[] = new R2Point[] { new R2Point(x1,y1), new R2Point(x2,y1), new R2Point(x2,y2), new R2Point(x1,y2), new R2Point(x1,y1) };
        for (int j = 0; j < 4; j++)
        {
            if ((R2Point.area(points[j], points[j+1], point) == 0) && point.inside(points[j], points[j+1]))
            {
                if (k[j] == 0)
                {
                    k[j]++;
                }
            }
        }
        Rectangle.KOL -= k[0] + k[1]+ k[2] + k[3];
        return Rectangle.KOL;
    }
}
