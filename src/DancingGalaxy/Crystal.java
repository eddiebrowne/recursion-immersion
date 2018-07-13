package DancingGalaxy;

import java.util.ArrayList;
import java.util.Random;

public class Crystal {

	ArrayList<Coordinates> bucket;
	int _length;
	public Crystal(){
		bucket = new ArrayList<Coordinates>();
	}
	
	public ArrayList<Coordinates> BuildCrystal(int length){		
      _length = -length;

		ArrayList<Coordinates> visited = new ArrayList<Coordinates>();
		if(length <= 0)
		{
			return visited;
		}
		
		Coordinates center = Coordinates.ComputeCenter(length);		
		Grow(length, visited, center);
		return bucket;
	}
	
	private void Grow(int length, ArrayList<Coordinates> visited, Coordinates current){
		visited.add(current);
		if(length <= 0){
			bucket = visited;
		}
		else{
			length--;

         Random random = new Random();
         int selection = random.nextInt(6); 
         //System.out.print(selection + " ");
         switch(selection)
         {
            case 0:
               GoLeft(length, visited, current);
               GoRight(length, visited, current);
               GoUp(length, visited, current);
               GoDown(length, visited, current);               
               break;
            case 1:
               GoUp(length, visited, current);
               GoDown(length, visited, current);               
               GoRight(length, visited, current);
               GoLeft(length, visited, current);
               break;
            case 2:
               GoUp(length, visited, current);
               GoRight(length, visited, current);
               GoDown(length, visited, current);
               GoLeft(length, visited, current);               
               break;
            case 3:               
               GoRight(length, visited, current);
               GoLeft(length, visited, current);
               GoUp(length, visited, current);
               GoDown(length, visited, current);
               break;
            case 4:
               GoUp(length, visited, current);
               GoLeft(length, visited, current);
               GoDown(length, visited, current);               
               GoRight(length, visited, current);
               break;
            case 5:
               GoLeft(length, visited, current);
               GoUp(length, visited, current);
               GoDown(length, visited, current);               
               GoRight(length, visited, current);
               break;
            case 6:
               GoDown(length, visited, current);
               GoUp(length, visited, current);
               GoLeft(length, visited, current);
               GoRight(length, visited, current);
               break;
            case 7:
               GoUp(length, visited, current);
               GoLeft(length, visited, current);
               GoRight(length, visited, current);
               GoDown(length, visited, current);
               break;
            case 8:
               GoUp(length, visited, current);               
               GoLeft(length, visited, current);
               GoDown(length, visited, current);
               GoRight(length, visited, current);
               break;
            case 9:
               GoUp(length, visited, current);
               GoDown(length, visited, current);
               GoLeft(length, visited, current);
               GoRight(length, visited, current);
               break;
            case 10:               
               GoDown(length, visited, current);
               GoLeft(length, visited, current);
               GoRight(length, visited, current);
               GoUp(length, visited, current);
               break;
            case 11:               
               GoDown(length, visited, current);
               GoLeft(length, visited, current);
               GoUp(length, visited, current);
               GoRight(length, visited, current);
               break;
            case 12:               
               GoDown(length, visited, current);
               GoUp(length, visited, current);
               GoLeft(length, visited, current);
               GoRight(length, visited, current);
               break;
         }         
		}
	}

   private void GoUp(int length, ArrayList<Coordinates> visited, Coordinates current)
   {
      Coordinates nextStep = new Coordinates(current.X(), current.Y() + 1, length);
		Go(length, visited, nextStep);
   }

   private void GoDown(int length, ArrayList<Coordinates> visited, Coordinates current)
   {
      Coordinates nextStep = new Coordinates(current.X(), current.Y() - 1, length);
		Go(length, visited, nextStep);
   }

   private void GoLeft(int length, ArrayList<Coordinates> visited, Coordinates current)
   {
      Coordinates nextStep = new Coordinates(current.X() - 1, current.Y(), length);
		Go(length, visited, nextStep);
   }

   private void GoRight(int length, ArrayList<Coordinates> visited, Coordinates current)
   {
      Coordinates nextStep = new Coordinates(current.X() + 1, current.Y(), length);
		Go(length, visited, nextStep);
   }

   private void Go(int length, ArrayList<Coordinates> visited, Coordinates nextStep)
   {
      if(!visited.contains(nextStep))
		{
			Grow(length, visited, nextStep);
		}
   }
}
