package programmingtest.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import programmingtest.figures.Point;

public class DistanceServiceTest {
	
	DistanceService distanceService = new DistanceService();
	
	@Test
	public void givenTwoPointsEstimateDistance() {
	    Point point1 = new Point(3, 4);
		Point point2 = new Point(7, 1);
	 
	    double distance = distanceService.distanceBetweenTwoPoints(point1, point2);
	 
	    assertEquals(distance, 5, 0.001);
	}
}
