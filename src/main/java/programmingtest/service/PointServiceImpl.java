package programmingtest.service;

import java.util.Set;

import javax.ws.rs.core.Response;

import programmingtest.errorhandling.AppException;
import programmingtest.figures.Point;

public class PointServiceImpl implements PointService {

	private Set<Point> points = Points.getInstance().points;

	@Override
	public void addPoint(Point point) throws AppException {

		validateInput(point);

		points.add(point);
	}

	private void validateInput(Point point) throws AppException {
		if (point == null) {
			throw new AppException("Point should have X and Y value in JSON format",
					Response.Status.BAD_REQUEST.getStatusCode());
		}

		if (point.getX() == null) {
			throw new AppException("Point should have an X value in JSON format",
					Response.Status.BAD_REQUEST.getStatusCode());
		}

		if (point.getY() == null) {
			throw new AppException("Point should have an Y value in JSON format",
					Response.Status.BAD_REQUEST.getStatusCode());
		}

	}

	@Override
	public Set<Point> getSpace() {
		return points;		
	}

}
