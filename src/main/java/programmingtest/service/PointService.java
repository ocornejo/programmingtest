package programmingtest.service;

import programmingtest.errorhandling.AppException;
import programmingtest.figures.Point;

public interface PointService {

	public void addPoint(Point point) throws AppException;
}
