package programmingtest.service;

import java.util.List;
import java.util.Set;

import programmingtest.figures.Point;

public interface CollinearService {

	public List<Set<Point>> getCollinearPointSet(int n);
	
	public List<Set<Point>> getCollinearPointSet2();
}
