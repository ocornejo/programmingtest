package programmingtest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class ApplicationEntryPoint {

	@GET
	public Response getStartingPage() {
		return Response.ok("Working API REST", MediaType.APPLICATION_JSON).build();
	}

}
