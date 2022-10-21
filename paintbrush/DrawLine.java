package paintbrush;


import java.awt.Color;
import java.awt.Graphics;


public class DrawLine extends AvailableShapes
{  
  
    public DrawLine()
    {
        super();
    }
    
  
    public DrawLine(int x1, int y1, int x2, int y2, Color color )
    {
        super(x1, y1, x2, y2, color);
    } 
     
   
    @Override
    public void graph( Graphics g )
    {
        g.setColor( getColor() ); 
        g.drawLine( getX_Coordinate(), getY_Coordinate(), getX_Dim(), getY_Dim() );
    } 
}