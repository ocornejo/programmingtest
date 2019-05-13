package programmingtest.service;

import java.util.Set;

import programmingtest.errorhandling.AppException;
import programmingtest.figures.Point;

public interface PointService {

	public void addPoint(Point point) throws AppException;

	public Set<Point> getSpace();

	public void deleteSpace();
}
