import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    private Convex convex;
    private Rectangle Rect;
    public Window(Convex convex1, Rectangle Rect1)
    {
         convex = convex1;
         Rect = Rect1;
         setSize(800,800);
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void paint(Graphics gr)
    {
        Graphics2D g = (Graphics2D)gr;
        g.setColor(Color.white);
        int x = getWidth(); int y = getHeight();
        g.translate(x/2, y/2);
        g.fillRect(-x/2,-y/2, x,y);
        g.setColor(Color.black);
        g.drawLine(0, -y/2, 0, y/2);
        g.drawLine(-x/2, 0, x/2,0);
        g.rotate(-Math.PI/2);
        g.setColor(Color.red);
        convex.draw(g);
        g.setColor(Color.BLUE);
        Rect.draw(g);
    }
    public void paint()
    {
        paint(getGraphics());
    }
}
