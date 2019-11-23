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
    public void paint (Graphics g)
    {
        convex.draw(g);
        Rect.draw(g);
    }
}
