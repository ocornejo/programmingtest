package programmingtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import programmingtest.figures.Point;

public class CollinearServiceImpl implements CollinearService {

	private DistanceService distanceService = new DistanceService();

	private Set<Point> points = Points.getInstance().points;

	private List<TreeSet<Point>> listCollinearSets = new ArrayList<TreeSet<Point>>();

	@Override
	public List<TreeSet<Point>> getCollinearPointSet2() {
		return null;
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
		removeSmallerLine(collinearPoints);
		
		listCollinearSets.add(collinearPoints);
	}

	private void removeSmallerLine(TreeSet<Point> collinearPoints) {

		if (listCollinearSets.isEmpty())
			return;

		double lengthOfCollinearPoints = distanceService.estimateMaxDistanceSet(collinearPoints);

		for (TreeSet<Point> setOfPoints : this.listCollinearSets) {
			if (lengthOfCollinearPoints > distanceService.estimateMaxDistanceSet(setOfPoints)) {
				this.listCollinearSets.remove(setOfPoints);
				return;
			}
		}
	}

	private boolean checkHasAtLeastNPoints(TreeSet<Point> collinearPoints, int n) {
		return collinearPoints.size() >= n ? true : false;
	}

	private boolean areCollinear(Point p1, Point p2, Point p3) {
		if (((p1.getY() - p2.getY()) * p3.getX() + (p2.getX() - p1.getX()) * p3.getY()
				+ (p1.getX() * p2.getY() - p2.getX() * p1.getY())) == 0) {
			return true;
		} else
			return false;
	}

	private boolean hasPoints(Point p1, Point p2, List<TreeSet<Point>> lisCollinearSets) {
		for (Set<Point> points : lisCollinearSets) {
			if (points.contains(p1) || points.contains(p2))
				return true;
		}
		return false;
	}

}
