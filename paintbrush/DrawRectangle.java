package paintbrush;

import java.awt.Color;
import java.awt.Graphics;


public class DrawRectangle extends RegularShapes
{ 
    
    public DrawRectangle()
    {
        super();
    }
    
  
    public DrawRectangle(int x1, int y1, int x2, int y2, Color color )
    {
        super(x1, y1, x2, y2, color);
    } 
    
    
    @Override
    public void graph( Graphics g ) {
        g.setColor(getColor());

        g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }
}