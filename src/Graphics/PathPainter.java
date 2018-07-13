package DancingGalaxy;

import java.util.ArrayList;


import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import DancingGalaxy.Coordinates;
import DancingGalaxy.PathFinder;

public class PathPainter extends JPanel implements Runnable{

   private volatile int _length;

	public PathPainter(int length){		
      _length = length;
	}
	
	public void PaintPaths(int length)
   {	
      Coordinates center = Coordinates.ComputeCenter(length);
      
      PathFinder pathFinder = new PathFinder();
      ArrayList<ArrayList<Coordinates>> path = pathFinder.FindAllPaths(length);

      int size = path.size();
      System.out.println("Size is: " + size);
      for(int i = 0; i < size; i++)
      {
         Grid grid = new Grid(path.get(i), center);
         Graphics graphics = getGraphics();
         grid.paint(graphics);
      }      
	}

   public void run(){
      PaintCrystal(_length);
   }

   private void PaintCrystal(int length)
   {
      Coordinates center = Coordinates.ComputeCenter(length); 
      Crystal crystal = new Crystal();
      ArrayList<Coordinates> path = crystal.BuildCrystal(length);
      Grid grid = new Grid(path, center);
      Graphics graphics = getGraphics();
      grid.paint(graphics);
   }
}
