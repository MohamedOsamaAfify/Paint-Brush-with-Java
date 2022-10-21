package paintbrush;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;

public class CreateFrame extends JFrame {

    private DrawPanel panel;

    private JButton undo;  
    private JButton clear;
    private JButton rect;
    private JButton oval;
    private JButton line;
    private JButton handSketch;
    private JButton erase;

    private JButton red;
    private JButton green;
    private JButton blue;


    private JComboBox shapes;

    private String shapeOptions[]
            = {"Line", "Rectangle", "Oval"};


    private JPanel widgetJPanel;
    private JPanel widgetPadder;

    public CreateFrame() {
        super("Paint Task");

        JLabel statusLabel = new JLabel("");

        panel = new DrawPanel(statusLabel);

        rect = new JButton("Rectangle");
        oval = new JButton("Oval");
        line = new JButton("Line");
        handSketch = new JButton("Hand Sketch");

        red= new JButton("Red");
        green= new JButton("Green");
        blue= new JButton("Blue");

        erase= new JButton("Erase");
        undo = new JButton("Undo");
        clear = new JButton("Clear");



        shapes = new JComboBox(shapeOptions);


        widgetJPanel = new JPanel();
       widgetJPanel.setLayout(new GridLayout(0, 1, 0, 60));

        widgetPadder = new JPanel();
        widgetPadder.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 5));

        widgetJPanel.add(rect);
        widgetJPanel.add(oval);
        widgetJPanel.add(line);
        widgetJPanel.add(handSketch);

        widgetJPanel.add(red);
        widgetJPanel.add(blue);
        widgetJPanel.add(green);

        widgetJPanel.add(undo);
        widgetJPanel.add(erase);
        widgetJPanel.add(clear);

        widgetPadder.add(widgetJPanel);

        add(widgetPadder, BorderLayout.EAST);
        add(panel, BorderLayout.CENTER);

        ButtonHandler buttonHandler = new ButtonHandler();
        undo.addActionListener(buttonHandler);
        
        clear.addActionListener(buttonHandler);
        rect.addActionListener(buttonHandler);
        oval.addActionListener(buttonHandler);
        line.addActionListener(buttonHandler);
        handSketch.addActionListener(buttonHandler);
        erase.addActionListener(buttonHandler);

        red.addActionListener(buttonHandler);
        blue.addActionListener(buttonHandler);
        green.addActionListener(buttonHandler);
                

        ItemListenerHandler handler = new ItemListenerHandler();
        shapes.addItemListener(handler);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1010, 1000);
        setVisible(true);

    }

    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand().equals("Undo")) {
                panel.clearLastShape();
            } else if (event.getActionCommand().equals("Clear")) {
                panel.clearDrawing();
            } else if (event.getActionCommand().equals("Rectangle")) {
                panel.setCurrentShapeType(1);

            } else if (event.getActionCommand().equals("Oval")) {
                panel.setCurrentShapeType(2);

            } else if (event.getActionCommand().equals("Line")) {
                panel.setCurrentShapeType(0);

            } else if (event.getActionCommand().equals("Hand Sketch")) {
                panel.setCurrentShapeType(3);

            }else if (event.getActionCommand().equals("Erase")) {
                panel.setCurrentShapeType(4);
            }
            else if (event.getActionCommand().equals("Red")) {
                panel.setCurrentShapeColor(Color.RED);
            }
            else if (event.getActionCommand().equals("Green")) {
                panel.setCurrentShapeColor(Color.GREEN);
            }
            else if (event.getActionCommand().equals("Blue")) {
                panel.setCurrentShapeColor(Color.BLUE);
            }
        }
    }

    private class ItemListenerHandler implements ItemListener {

        public void itemStateChanged(ItemEvent event) {

            if (event.getStateChange() == ItemEvent.SELECTED) {
              if (event.getSource() == shapes) {
                    panel.setCurrentShapeType(shapes.getSelectedIndex());
                }
            }
        }
    }
}