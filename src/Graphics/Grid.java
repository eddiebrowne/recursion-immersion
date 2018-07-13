package DancingGalaxy;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;

import DancingGalaxy.Coordinates;

@SuppressWarnings("serial")
public class Grid extends JFrame {

	int scalar = 5;
	int x;
	int y;
   
	int red = 0;
	int green = 0;
	int blue = 0;
	
   int blueDelta = 3;
   int redDelta = 10;
   int greenDelta = 3;

   int _offsetX;
   int _offsetY;

   Coordinates _center;

	Random r = new Random();
	ArrayList<Coordinates> coordinateList;
	
	public Grid(ArrayList<Coordinates> list, Coordinates center){
		coordinateList = list;
      _center = center;
      _offsetX = 3*center.X();
      _offsetY = 4*center.Y();

      System.out.println(center);
	}
	
	private void Draw(Coordinates coordinates){
//      System.out.println(coordinates);
		x = (coordinates.X()*scalar) - _offsetX;
		y = (coordinates.Y()*scalar) - _offsetY;
      //System.out.println(x + "," + y);
      //x = scalar * coordinates.X();
      //y = scalar * coordinates.Y() - _center.Y();
	}
	
	public void paint(Graphics g){		
      super.paint(g);

		Iterator<Coordinates> iter = coordinateList.iterator();
		while(iter.hasNext()){
 			Wait();

         Coordinates currentCoordinates = iter.next();
			Draw(currentCoordinates);

         int length = Math.abs(currentCoordinates.Length());

         
         red   = length % 90;
         green = (length % 200) + 50;
         blue  = length % 150;
         
         if(length <= 0)
         {
            red = 254;
            green = 0;
            blue = 0;
         }

         /*
         red = (red + redDelta) % 150;
         green = (green + greenDelta) % 250;
         blue = (blue + blueDelta) % 250;
         */

			g.setColor(new Color(red, green, blue));         
			g.fillRect(x, y, scalar, scalar);
		}		
	}	

   private void Wait(){
      try {
          Thread.sleep(1);
      } catch (InterruptedException exception) {
          exception.printStackTrace();        
      }
   }
}
