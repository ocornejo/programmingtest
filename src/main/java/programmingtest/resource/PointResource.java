package programmingtest.resource;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import programmingtest.errorhandling.AppException;
import programmingtest.figures.Point;
import programmingtest.service.PointService;
import programmingtest.service.PointServiceImpl;

/**
 * Resource that handles the requests for managing points
 * 
 * @author cornejo
 *
 */

@Path("/")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class PointResource {
	
	private PointService pointService = new PointServiceImpl();
	
	@POST
	@Path("/point")
	public Response addPoint(Point p) throws AppException {
		
		pointService.addPoint(p);

		return Response.status(Response.Status.CREATED) // 201
				.build();
	}
	
	@GET
	@Path("/space")
	public Response getSpace() {
		
		Set<Point> pointsInSpace = pointService.getSpace();
		
		return Response.status(Response.Status.OK) // 200
				.entity(new GenericEntity<Set<Point>>(pointsInSpace) {})
				.build();
	}
	
	@DELETE
	@Path("/space")
	public Response deleteSpace() {
		
		pointService.deleteSpace();
		
		return Response.status(Response.Status.NO_CONTENT) // 204
				.build();
	}
}
