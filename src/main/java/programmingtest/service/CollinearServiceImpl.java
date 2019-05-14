package programmingtest.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import programmingtest.figures.Point;
import programmingtest.utils.Utils;

public class CollinearServiceImpl implements CollinearService {

	private Set<Point> points = Points.getInstance().points;
	
	private List<Set<Point>> listCollinearSets = new ArrayList<Set<Point>>();

	@Override
	public List<Set<Point>> getCollinearPointSet(int n) {
		int i = 0;
		int j = 0;
		int k = 0;

		Point[] pointsArray = points.toArray(new Point[points.size()]);

		for (i = 0; i < pointsArray.length; i++) {
			for (j = i + 1; j < pointsArray.length; j++) {
				// Skip the combination of points[i] and points[j] if these two points
				// are already present in previously calculated collinear set.
				if (Utils.hasPoints(pointsArray[i], pointsArray[j], listCollinearSets)) {
					break;
				}

				Set<Point> collinearPoints = new HashSet<Point>();

				for (k = j + 1; k < pointsArray.length; k++) {
					if (Utils.areCollinear(pointsArray[i], pointsArray[j], pointsArray[k])) {
						collinearPoints.add(pointsArray[i]);
						collinearPoints.add(pointsArray[j]);
						collinearPoints.add(pointsArray[k]);
					}
				}
				if (!collinearPoints.isEmpty() 
						&& checkHasAtLeastNPoints(collinearPoints, n)
						&& checkLarger(collinearPoints)) {
					listCollinearSets.add(collinearPoints);
				}	
			}
		}
		return listCollinearSets;
	}

	private boolean checkLarger(Set<Point> collinearPoints) {
		return true;
	}

	private boolean checkHasAtLeastNPoints(Set<Point> collinearPoints, int n) {
		return collinearPoints.size() >= n ? true : false;
	}

	@Override
	public List<Set<Point>> getCollinearPointSet2() {
		return null;
	}

}
