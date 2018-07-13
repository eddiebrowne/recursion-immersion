package DancingGalaxy;

import java.util.ArrayList;

public class PathFinder {

	ArrayList<ArrayList<Coordinates>> bucket;
	int _length;

	public PathFinder(){
		bucket = new ArrayList<ArrayList<Coordinates>>();
	}
	
	public ArrayList<ArrayList<Coordinates>> FindAllPaths(int length){		
      _length = -length;

		ArrayList<Coordinates> visited = new ArrayList<Coordinates>();
		if(length <= 0)
		{
			return bucket;
		}
		
		Coordinates center = Coordinates.ComputeCenter(length);		
		DanceGalaxy(length, visited, center);
		return bucket;
	}
	
	private void DanceGalaxy(int length, ArrayList<Coordinates> visited, Coordinates current){
		//System.out.println(current + " " + visited.toString());
		visited.add(current);
		if(length <= 0)
      {
         bucket.add(visited);
		}
		else{
			length--;         

         ArrayList<Coordinates> list;

         list = new ArrayList<Coordinates>(visited);
         GoUp(length, list, current);

         list = new ArrayList<Coordinates>(visited);
         GoLeft(length, list, current);

         list = new ArrayList<Coordinates>(visited);
         GoRight(length, list, current);

         list = new ArrayList<Coordinates>(visited);
         GoDown(length, list, current);
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
			DanceGalaxy(length, visited, nextStep);
		}
   }
}
