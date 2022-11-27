import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class Test extends JPanel {

    private boolean drag = false;
    private Point dragLocation  = new Point();

    public  Test() {
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        setPreferredSize(new Dimension(500, 500));
        final JFrame f = new JFrame("Test");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drag = true;
                dragLocation = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                drag = false;
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (drag) {
                    if (dragLocation.getX()> getWidth()-10 && dragLocation.getY()>getHeight()-10) {
                        System.err.println("in");
                        setSize((int)(getWidth()+(e.getPoint().getX()-dragLocation.getX())),
                                (int)(getHeight()+(e.getPoint().getY()-dragLocation.getY())));
                        dragLocation = e.getPoint();
                    }
                }
            }
        });
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(this,BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

}