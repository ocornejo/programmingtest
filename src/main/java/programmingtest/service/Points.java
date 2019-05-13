package programmingtest.service;

import java.util.HashSet;
import java.util.Set;

import programmingtest.figures.Point;

/**
 * Singleton class that represents the collection of points
 * 
 * @author cornejo
 *
 */
public class Points {

	private static Points instance = null;

	public Set<Point> points;

	private Points() {
		points = new HashSet<Point>();
	}

	public static Points getInstance() {
		if (instance == null)
			instance = new Points();

		return instance;
	}

}
