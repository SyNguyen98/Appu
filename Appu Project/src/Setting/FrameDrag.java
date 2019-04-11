package Setting;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class FrameDrag extends MouseAdapter {
    private final JFrame frame;
    private Point mouseDownCompCoords = null;

    public FrameDrag(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseDownCompCoords = null;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseDownCompCoords = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point currCoords = e.getLocationOnScreen();
        frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }
}
