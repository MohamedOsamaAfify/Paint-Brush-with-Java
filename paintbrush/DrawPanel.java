package paintbrush;



import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class DrawPanel extends JPanel {

    private LinkedList<AvailableShapes> myShapes;
    private LinkedList<AvailableShapes> clearedShapes;

    private int ShapeType;
    private AvailableShapes ShapeObject;
    private Color ShapeColor;
    JLabel statusLabel;

    public DrawPanel(JLabel LabelStatus) {

        myShapes = new LinkedList<AvailableShapes>();
        clearedShapes = new LinkedList<AvailableShapes>();

        ShapeType = 0;
        ShapeObject = null;
        ShapeColor = Color.CYAN;
        this.statusLabel = LabelStatus;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        add(LabelStatus, BorderLayout.NORTH);

        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<AvailableShapes> shapeArray = myShapes.getArray();
        for (int counter = shapeArray.size() - 1; counter >= 0; counter--) {
            shapeArray.get(counter).graph(g);
        }

        if (ShapeObject != null) {
            ShapeObject.graph(g);
        }
    }

    public void setCurrentShapeType(int type) {
        ShapeType = type;
    }

    public void setCurrentShapeColor(Color color) {
        ShapeColor = color;
    }

    public void clearLastShape() {
        if (!myShapes.isEmpty()) {
            clearedShapes.addFront(myShapes.removeFront());
            repaint();
        }
    }
    public void clearDrawing() {
        myShapes.makeEmpty();
        clearedShapes.makeEmpty();
        repaint();
    }
    private class MouseHandler extends MouseAdapter {

        public void mousePressed(MouseEvent event) {
            switch (ShapeType) 
            {
                case 0:
                    ShapeObject = new DrawLine(event.getX(), event.getY(),
                            event.getX(), event.getY(), ShapeColor);
                    break;
                case 1:
                    ShapeObject = new DrawRectangle(event.getX(), event.getY(),
                            event.getX(), event.getY(), ShapeColor);
                    break;
                case 2:
                    ShapeObject = new DrawOval(event.getX(), event.getY(),
                            event.getX(), event.getY(), ShapeColor);
                    break;
                case 3:
                    ShapeObject = new FreeHandSketch(event.getX(), event.getY(),
                            event.getX(), event.getY(), ShapeColor);
                    break;
                case 4:
                    ShapeObject = new Erase (event.getX(), event.getY(),
                            event.getX(), event.getY(), Color.WHITE);
            }
        }

        public void mouseReleased(MouseEvent event) {

            ShapeObject.setX_Dim(event.getX());
            ShapeObject.setY_Dim(event.getY());

            myShapes.addFront(ShapeObject);

            ShapeObject = null;
            clearedShapes.makeEmpty();
            repaint();
        }

        public void mouseMoved(MouseEvent event) {
         
        }

        public void mouseDragged(MouseEvent event) {

            ShapeObject.setX_Dim(event.getX());
            ShapeObject.setY_Dim(event.getY());

            repaint();
        }
    }
}
