package programmingtest.service;

import java.util.Set;

import programmingtest.figures.Point;

public class DistanceService {

	public double estimateMaxDistanceSet(Set<Point> setOfPoints) {
		Point[] pointArray = setOfPoints.toArray(new Point[setOfPoints.size()]);

		return distanceBetweenTwoPoints(pointArray[0], pointArray[setOfPoints.size() - 1]);
	}

	protected double distanceBetweenTwoPoints(Point p1, Point p2) {
		return Math.sqrt(
				(p2.getY() - p1.getY()) * (p2.getY() - p1.getY()) + (p2.getX() - p1.getX()) * (p2.getX() - p1.getX()));
	}

}
