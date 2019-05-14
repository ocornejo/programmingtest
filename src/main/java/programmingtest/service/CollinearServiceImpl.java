package programmingtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import programmingtest.figures.Point;
import programmingtest.utils.DistanceUtil;

public class CollinearServiceImpl implements CollinearService {

	private DistanceUtil distanceService = new DistanceUtil();

	private Set<Point> points = Points.getInstance().points;

	private List<TreeSet<Point>> collinearPointSets = new ArrayList<TreeSet<Point>>();

	@Override
	public List<TreeSet<Point>> getCollinearPointSetForN2() {
		int i = 0;
		int j = 0;

		Point[] pointsArray = points.toArray(new Point[points.size()]);

		for (i = 0; i < pointsArray.length; i++) {
			for (j = i + 1; j < pointsArray.length; j++) {
				if (hasPoints(pointsArray[i], pointsArray[j], collinearPointSets)) {
					break;
				}

				TreeSet<Point> collinearPoints = new TreeSet<Point>();

				collinearPoints.add(pointsArray[i]);
				collinearPoints.add(pointsArray[j]);

				addToCollinearSet(collinearPoints);
			}
		}
		return collinearPointSets;
	}

	@Override
	public List<TreeSet<Point>> getCollinearPointSet(int n) {
		int i = 0;
		int j = 0;
		int k = 0;
		
		// transform set to array for iteration simplicity
		Point[] pointsArray = points.toArray(new Point[points.size()]);

		for (i = 0; i < pointsArray.length; i++) {
			for (j = i + 1; j < pointsArray.length; j++) {
				// skip combination of i and j if those points were already considered
				if (hasPoints(pointsArray[i], pointsArray[j], collinearPointSets)) {
					break;
				}

				TreeSet<Point> collinearPoints = new TreeSet<Point>();

				for (k = j + 1; k < pointsArray.length; k++) {
					if (areCollinear(pointsArray[i], pointsArray[j], pointsArray[k])) {
						collinearPoints.add(pointsArray[i]);
						collinearPoints.add(pointsArray[j]);
						collinearPoints.add(pointsArray[k]);
					}
				}
				
				// checks if the set of collinear points has at least N points
				if (!collinearPoints.isEmpty() && checkHasAtLeastNPoints(collinearPoints, n)) {
					addToCollinearSet(collinearPoints);
				}
			}
		}
		return collinearPointSets;
	}
	
	/**
	 * 
	 * @param collinearPoints
	 */
	private void addToCollinearSet(TreeSet<Point> collinearPointsSet) {
		boolean hasRemoved = removeSmallerLine(collinearPointsSet);

		if (hasRemoved)
			collinearPointSets.add(collinearPointsSet);
	}

	/**
	 * 
	 * Attempts to remove a smaller line in the listCollinearSets
	 * @param collinearPoints
	 * @return true if has removed a smaller line, otherwise it returns false
	 * 
	 */
	private boolean removeSmallerLine(TreeSet<Point> collinearPoints) {

		if (collinearPointSets.isEmpty())
			return true;

		double lengthOfCollinearPoints = distanceService.estimateMaxDistanceSet(collinearPoints);

		for (TreeSet<Point> line : this.collinearPointSets) {
			if (lengthOfCollinearPoints > distanceService.estimateMaxDistanceSet(line)) {
				this.collinearPointSets.remove(line);
				return true;
			}
		}
		return false;
	}
	
	
	private boolean checkHasAtLeastNPoints(TreeSet<Point> collinearPoints, int n) {
		return collinearPoints.size() >= n ? true : false;
	}
	
	/**
	 * Receives three points and determines if they are collinear
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return true if they are collinear
	 */
	private boolean areCollinear(Point p1, Point p2, Point p3) {
		if (((p1.getY() - p2.getY()) * p3.getX() + (p2.getX() - p1.getX()) * p3.getY()
				+ (p1.getX() * p2.getY() - p2.getX() * p1.getY())) == 0) {
			return true;
		} else
			return false;
	}

	private boolean hasPoints(Point point1, Point point2, List<TreeSet<Point>> lisCollinearSets) {
		for (Set<Point> points : lisCollinearSets) {
			if (points.contains(point1) || points.contains(point2))
				return true;
		}
		return false;
	}

}
