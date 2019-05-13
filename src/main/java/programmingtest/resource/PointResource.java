package programmingtest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import programmingtest.errorhandling.AppException;
import programmingtest.figures.Point;
import programmingtest.service.PointService;
import programmingtest.service.PointServiceImpl;

@Path("/")
public class PointResource {
	
	private PointService pointService = new PointServiceImpl();
	
	@POST
	@Path("/point")
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response addPoint(Point p) throws AppException {
		
		pointService.addPoint(p);

		return Response.status(Response.Status.CREATED) // 201
				.entity("A new point has been created")
				.build();
	}
}
