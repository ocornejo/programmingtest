package programmingtest.service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.ws.rs.core.Response;

import programmingtest.errorhandling.AppException;
import programmingtest.figures.Point;

public class LineServiceImpl implements LineService {

	private Set<Point> points = Points.getInstance().points;
	private CollinearService collinearService = new CollinearServiceImpl();

	@Override
	public List<TreeSet<Point>> getLines(int n) throws AppException {

		validateInput(n);

		if (points.size() < 2) {
			throw new AppException("not enough points in the space", Response.Status.BAD_REQUEST.getStatusCode());
		} else if (n == 2) {
			return collinearService.getCollinearPointSetForN2();
		} else {
			return collinearService.getCollinearPointSet(n);
		}

	}

	private void validateInput(int n) throws AppException {
		if (n < 2) {
			throw new AppException("n should be greater or equal than 2", Response.Status.BAD_REQUEST.getStatusCode());
		}
	}

}
