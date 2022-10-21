package paintbrush;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class FreeHandSketch extends AvailableShapes {

    ArrayList<Integer> xArray = new ArrayList<Integer>();
    ArrayList<Integer> yArray = new ArrayList<Integer>();

    public FreeHandSketch() {

    }

    public FreeHandSketch(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void graph(Graphics g) {
        xArray.add(getX_Dim());
        yArray.add(getY_Dim());
        g.setColor( getColor() ); 
        for(int i = 0; i < xArray.size() - 1; i++) {
			g.drawLine(xArray.get(i), yArray.get(i), xArray.get(i+1), yArray.get(i+1));
		}
    }
}
