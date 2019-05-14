package programmingtest.service;

import java.util.List;
import java.util.TreeSet;

import programmingtest.errorhandling.AppException;
import programmingtest.figures.Point;

public interface LineService {

	List<TreeSet<Point>> getLines(int n) throws AppException;

}
