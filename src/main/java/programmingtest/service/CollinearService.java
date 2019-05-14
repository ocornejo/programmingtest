package programmingtest.service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import programmingtest.figures.Point;

public interface CollinearService {

	public List<TreeSet<Point>> getCollinearPointSet(int n);
	
	public List<TreeSet<Point>> getCollinearPointSet2();
}
