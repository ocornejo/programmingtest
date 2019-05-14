package programmingtest.utils;

import java.util.Set;

import programmingtest.figures.Point;

public class DistanceUtil {
	
	/**
	 * Receives a set of points and determines the maximum length
	 * by using the first and the last point of the line
	 * 
	 */
	public double estimateMaxDistanceSet(Set<Point> line) {
		Point[] pointArray = line.toArray(new Point[line.size()]);
		
		return distanceBetweenTwoPoints(pointArray[0], pointArray[line.size() - 1]);
	}
	
	/**
	 * @return the distance between two points
	 */
	protected double distanceBetweenTwoPoints(Point p1, Point p2) {
		return Math.sqrt(
				(p2.getY() - p1.getY()) * (p2.getY() - p1.getY()) + (p2.getX() - p1.getX()) * (p2.getX() - p1.getX()));
	}

}
