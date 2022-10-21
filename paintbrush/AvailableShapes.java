package paintbrush;


import java.awt.*;


abstract class AvailableShapes
{
    private int x_Coordinate,y_Coordinate,x_Dim,y_Dim;
    private Color color; 
    
    
    public AvailableShapes()
    {
        x_Coordinate = y_Coordinate = x_Dim = y_Dim = 0;
        color=Color.GRAY;
    }
    
   
    public AvailableShapes(int x_Coordinate, int y_Coordinate, int x_Dim, int y_Dim, Color color)
    {
        this.x_Coordinate = x_Coordinate;
        this.y_Coordinate = y_Coordinate;
        this.x_Dim = x_Dim;
        this.y_Dim = y_Dim;
        this.color=color;
    }
    
    public void setX_Dim(int x_Dim)
    {
        this.x_Dim=x_Dim;
    }   
    
   
    public void setY_Dim(int y_Dim)
    {
        this.y_Dim=y_Dim;
    }   
    
   
    public void setX_Coordinate(int x_Coordinate)
    {
        this.x_Coordinate=x_Coordinate;
    }   
    
    public void setY_Coordinate(int y_Coordinate)
    {
        this.y_Coordinate=y_Coordinate;
    }   
  
    public void setColor(Color color)
    {
        this.color=color;
    }
    
    
    public int getX_Dim()
    {
        return x_Dim;
    }
    
   
    public int getY_Dim()
    {
        return y_Dim;
    }
    
    
    public int getX_Coordinate()
    {
        return x_Coordinate;
    }
    
  
    public int getY_Coordinate()
    {
        return y_Coordinate;
    }
    
    
    public Color getColor()
    {
        return color;
    }
    

    abstract public void graph( Graphics g );
}