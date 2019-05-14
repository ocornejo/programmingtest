package programmingtest.service;

import java.util.List;
import java.util.Set;

import programmingtest.errorhandling.AppException;
import programmingtest.figures.Point;

public interface LineService {

	List<Set<Point>> getLines(int n) throws AppException;

}
