package paintbrush;

import java.awt.Color;
import java.awt.Graphics;


public class Erase extends RegularShapes
{ 
  
    public Erase()
    {}

    public Erase ( int x1, int y1, int x2, int y2, Color color )
    {
        super(x1, y1, x2, y2, color);
    }
     
   
    @Override
    public void graph( Graphics g )
    {
        g.setColor( Color.WHITE );
       
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
    }
}