package DancingGalaxy;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.lang.Thread;

public class Main {

	public static void main(String[] args){

      int input = Integer.parseInt(args[0]);
		System.out.println("hi");
		//DancingGalaxy galaxy = new DancingGalaxy();
      //int count = galaxy.GalaxyLauncher(input);
      //System.out.println(count);  

		PathPainter painter = new PathPainter(input);

      JFrame frame = new JFrame("Let's go!");
      frame.getContentPane().add(painter);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(2000, 1000);
      frame.setVisible(true);

      //painter.PaintPaths(input);
      new Thread(painter).start();
      /*
      new Thread(painter).start();
      new Thread(painter).start();
      new Thread(painter).start();
      new Thread(painter).start();
      new Thread(painter).start();
      new Thread(painter).start();
/*
      (new PathPainter(input)).start();
      (new PathPainter(input)).start();
      (new PathPainter(input)).start();
*/
      //painter.PaintPaths(input);
      //painter.PaintCrystal(input);
		
      System.out.println("All done!");  

//		int previous = 0;
//		int current;
//		for(int i = 0; i < 200; i++){
//			current = galaxy.GalaxyLauncher(i);			
//			//System.out.println(i + " -- diff: " + (current - previous) + " raw: " + current);
//			System.out.println(current);//-previous);
//			previous = current;			
//		}		
	}
}
