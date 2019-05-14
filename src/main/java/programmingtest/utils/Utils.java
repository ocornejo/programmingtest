package programmingtest.utils;

import java.util.List;
import java.util.Set;

import programmingtest.figures.Point;

public class Utils {
	
	private Utils() {}
	
	public static boolean areCollinear(Point p1, Point p2, Point p3) {
		if (((p1.getY() - p2.getY()) * p3.getX() + (p2.getX() - p1.getX()) * p3.getY()
				+ (p1.getX() * p2.getY() - p2.getX() * p1.getY())) == 0) {
			return true;
		} else
			return false;
	}

	public static boolean hasPoints(Point p1, Point p2, List<Set<Point>> lisCollinearSets) {
		for (Set<Point> points : lisCollinearSets) {
			if (points.contains(p1) || points.contains(p2))
				return true;
		}
		return false;
	}
}
