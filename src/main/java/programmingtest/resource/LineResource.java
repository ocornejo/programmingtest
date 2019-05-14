package programmingtest.resource;

import java.util.List;
import java.util.TreeSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import programmingtest.errorhandling.AppException;
import programmingtest.figures.Point;
import programmingtest.service.LineService;
import programmingtest.service.LineServiceImpl;

/**
 * Resource that handles the request for analyzing lines
 * 
 * @author cornejo
 *
 */
@Path("/")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class LineResource {
	
	private LineService lineService = new LineServiceImpl();

	@GET
	@Path("/lines/{n}")
	public Response getLines(@PathParam("n") int n) throws AppException {
		
		List<TreeSet<Point>> lines = lineService.getLines(n);
		GenericEntity<List<TreeSet<Point>>> x = new GenericEntity<List<TreeSet<Point>>>(lines) {};

		return Response.status(Response.Status.OK) //200
				.entity(x)
				.build();
	}
}
