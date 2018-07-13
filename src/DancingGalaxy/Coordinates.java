package DancingGalaxy;

public class Coordinates {
	private int _x;
	private int _y;
	private int _length;
	
	public Coordinates(int x, int y){
		_x = x;
		_y = y;
	}

   public Coordinates(int x, int y, int length)
   {
      _x = x;
      _y = y;
      _length = length;
   }
		
	public String toString(){		
		return "("+_x+","+_y+")";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _x;
		result = prime * result + _y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (_x != other._x)
			return false;
		if (_y != other._y)
			return false;
		return true;
	}

	public int X(){
		return _x;		
	}
	public int Y(){
		return _y;
	}

   public int Length(){
      return _length;
   }
	
	public static Coordinates ComputeCenter(int length){
		int middle = (length/2) - 1;
		return new Coordinates(middle, middle);
	}
}
