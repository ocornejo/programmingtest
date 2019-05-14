package programmingtest.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

import programmingtest.figures.Point;
import programmingtest.resource.PointResource;

public class PointResourceTest extends JerseyTest {

	@Override
	public Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		return new ResourceConfig(PointResource.class);
	}
	
	@Test
	public void testAddPoint() {
		Point point = new Point(1, 2);
		
		Response output = target("/point").request().post(Entity.entity(point, MediaType.APPLICATION_JSON));

		assertEquals("Should return status 201", 201, output.getStatus());
	}
		
	@Test
	public void testGetSpace() {
		
		Point point1 = new Point(1, 2);
		Point point2 = new Point(13, 21);
		Point point3 = new Point(14, 2);
		Point point4 = new Point(15, 12);
		
		target("/point").request().post(Entity.entity(point1, MediaType.APPLICATION_JSON));
		target("/point").request().post(Entity.entity(point2, MediaType.APPLICATION_JSON));
		target("/point").request().post(Entity.entity(point3, MediaType.APPLICATION_JSON));
		target("/point").request().post(Entity.entity(point4, MediaType.APPLICATION_JSON));
		
		
		Response response = target("/space").request().get();
		assertEquals("should return status 200", 200, response.getStatus());
		assertNotNull("Should return points list", response.getEntity().toString());
	}
	
	@Test
	public void testDeleteSpace() {
		
		Point point1 = new Point(8, -2);		
		target("/point").request().post(Entity.entity(point1, MediaType.APPLICATION_JSON));
		
		Response output = target("/space").request().delete();
		assertEquals("Should return status 204", 204, output.getStatus());
	}
}
