import java.util.Scanner;
public class ConvexTest {
    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();
        System.out.println("Введите две точки для прямоугольника");
        R2Point point1 = new R2Point();
        R2Point point2 = new R2Point();
        Rectangle Rect = new Rectangle(point1, point2);
        Window w = new Window(convex, Rect);
        System.out.println("Введите точки для выпуклой оболочки");
        while (true) {
            try {
                R2Point point = new R2Point();
                convex.add(point);
                w.paint();
                System.out.println("S = " + convex.area() + " , P = " + convex.perimeter()+ " Сумма точек = " + convex.calc());
            }
            catch (Exception ex)
            {
                break;
            }
        }

    }
}