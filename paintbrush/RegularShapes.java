/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paintbrush;


import java.awt.Color;
import java.awt.Graphics;


abstract class RegularShapes extends AvailableShapes
{
    public RegularShapes()
    {
        super();
    }

 
    public RegularShapes(int x1, int y1, int x2, int y2, Color color)
    {
        super(x1, y1, x2, y2, color);
    }


    public int getUpperLeftX()
    {
        return Math.min(getX_Coordinate(),getX_Dim());
    }
    
   
    public int getUpperLeftY()
    {
        return Math.min(getY_Coordinate(),getY_Dim());
    }
    
   
    public int getWidth()
    {
        return Math.abs(getX_Coordinate()-getX_Dim());
    }

    public int getHeight()
    {
        return Math.abs(getY_Coordinate()-getY_Dim());
    }


    abstract public void graph( Graphics g );
}