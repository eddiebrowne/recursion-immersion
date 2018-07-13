package DancingGalaxy;

import java.util.ArrayList;

public class DancingGalaxy {

	private int _count;
	
	public DancingGalaxy(){
		_count = 0;
	}
	
	public int GalaxyLauncher(int length){
		if(length <= 0)
		{
			return 0;
		}
		
		Coordinates center = Coordinates.ComputeCenter(length);   
		
		ArrayList<Coordinates> visited = new ArrayList<Coordinates>();
		//visited.add(center);
		
		DanceGalaxy(length - 1, visited, center);
		return _count;
	}
	
	private int DanceGalaxy(int length, ArrayList<Coordinates> visited, Coordinates current){
		//System.out.println(_length + " : " + current + " " + visited.toString());
		if(length == 0){
			_count++;			
		}
		else{
			// find new place to go
			// try to the left first, then up, then right, then down

			length--;
			visited.add(current);
			
			Coordinates nextStep = new Coordinates(current.X() - 1, current.Y()); // left						
			if(!visited.contains(nextStep))
			{			
				DanceGalaxy(length, visited, nextStep);
			}
			
			nextStep = new Coordinates(current.X(), current.Y() + 1); // up
			if(!visited.contains(nextStep))
			{
				DanceGalaxy(length, visited, nextStep);
			}
			
			nextStep = new Coordinates(current.X() + 1, current.Y()); // right
			if(!visited.contains(nextStep))
			{
				DanceGalaxy(length, visited, nextStep);
			}
			
			nextStep = new Coordinates(current.X(), current.Y() - 1); // down
			if(!visited.contains(nextStep))
			{
				DanceGalaxy(length, visited, nextStep);
			}
		}
		return _count;
	}	
}
