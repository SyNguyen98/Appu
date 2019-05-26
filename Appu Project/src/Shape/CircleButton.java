package Shape;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class CircleButton extends JButton {
    public CircleButton() {
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder());
    }    
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillOval(0, 0, getSize().width-1, getSize().height-1);
        super.paintComponent(g);
    }
    @Override
    public boolean contains(int x, int y) {
        Shape shape = null;
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }
}