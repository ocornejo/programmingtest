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

	private List<TreeSet<Point>> listCollinearSets = new ArrayList<TreeSet<Point>>();

	@Override
	public List<TreeSet<Point>> getCollinearPointSetForN2() {
		int i = 0;
		int j = 0;

		Point[] pointsArray = points.toArray(new Point[points.size()]);

		for (i = 0; i < pointsArray.length; i++) {
			for (j = i + 1; j < pointsArray.length; j++) {
				if (hasPoints(pointsArray[i], pointsArray[j], listCollinearSets)) {
					break;
				}

				TreeSet<Point> collinearPoints = new TreeSet<Point>();

				collinearPoints.add(pointsArray[i]);
				collinearPoints.add(pointsArray[j]);

				addToCollinearSet(collinearPoints);
			}
		}
		return listCollinearSets;
	}

	@Override
	public List<TreeSet<Point>> getCollinearPointSet(int n) {
		int i = 0;
		int j = 0;
		int k = 0;

		Point[] pointsArray = points.toArray(new Point[points.size()]);

		for (i = 0; i < pointsArray.length; i++) {
			for (j = i + 1; j < pointsArray.length; j++) {
				// Skip the combination of points[i] and points[j] if these two points
				// are already present in previously calculated collinear set.
				if (hasPoints(pointsArray[i], pointsArray[j], listCollinearSets)) {
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
				if (!collinearPoints.isEmpty() && checkHasAtLeastNPoints(collinearPoints, n)) {
					addToCollinearSet(collinearPoints);
				}
			}
		}
		return listCollinearSets;
	}

	private void addToCollinearSet(TreeSet<Point> collinearPoints) {
		boolean hasRemoved = removeSmallerLine(collinearPoints);

		if (hasRemoved)
			listCollinearSets.add(collinearPoints);
	}

	private boolean removeSmallerLine(TreeSet<Point> collinearPoints) {

		if (listCollinearSets.isEmpty())
			return true;

		double lengthOfCollinearPoints = distanceService.estimateMaxDistanceSet(collinearPoints);

		for (TreeSet<Point> setOfPoints : this.listCollinearSets) {
			if (lengthOfCollinearPoints > distanceService.estimateMaxDistanceSet(setOfPoints)) {
				this.listCollinearSets.remove(setOfPoints);
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
