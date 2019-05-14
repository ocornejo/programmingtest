package programmingtest.service;

import java.util.List;
import java.util.TreeSet;

import programmingtest.figures.Point;

public interface CollinearService {

	public List<TreeSet<Point>> getCollinearPointSet(int n);
	
	public List<TreeSet<Point>> getCollinearPointSetForN2();
}
