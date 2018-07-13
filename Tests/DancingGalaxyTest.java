package DancingGalaxyTests;

import static org.junit.Assert.*;

import org.junit.Test;

import DancingGalaxy.Coordinates;
import DancingGalaxy.DancingGalaxy;

public class DancingGalaxyTest {

	// Arrange
	
	// Act
			
	// Assert
	
	@Test
	public void OneSquareTest(){
		// Arrange
		DancingGalaxy galaxy = new DancingGalaxy();
		int expected = 1;
		int length = 1;
		
		// Act
		int actual = galaxy.GalaxyLauncher(length);
		
		// Assert	
		assertEquals(expected, actual);
	}
	
	@Test
	public void TwoSquareTest(){
		// Arrange
		DancingGalaxy galaxy = new DancingGalaxy();
		int expected = 4;
		int length = 2;
		
		// Act
		int actual = galaxy.GalaxyLauncher(length);
		
		// Assert	
		assertEquals(expected, actual);
	}
	
	@Test
	public void ThreeSquareTest(){
		// Arrange
		DancingGalaxy galaxy = new DancingGalaxy();
		int expected = 12;
		int length = 3;
		
		// Act
		int actual = galaxy.GalaxyLauncher(length);
		
		// Assert	
		assertEquals(expected, actual);
	}
	
	@Test
	public void MiddleTest(){

		// Arrange
		Coordinates expected = new Coordinates(2, 2);
		
		int length = 3;
		
		// Act
		Coordinates actual = Coordinates.ComputeCenter(length);
		
		// Assert	
		assertEquals(expected, actual);		
	}
	
}
