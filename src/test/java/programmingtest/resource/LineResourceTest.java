package programmingtest.resource;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;

import programmingtest.figures.Point;

@RunWith(JUnitParamsRunner.class)
public class LineResourceTest extends JerseyTest {

	@Override
	public Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		return new ResourceConfig(LineResource.class, PointResource.class);
	}

	@Test
	public void testCollinearPoints() {

		Point point1 = new Point(10000, 0);
		Point point2 = new Point(0, 10000);
		Point point3 = new Point(3000, 7000);
		Point point4 = new Point(7000, 3000);
		Point point5 = new Point(20000, 21000);
		Point point6 = new Point(3000, 4000);
		Point point7 = new Point(14000, 15000);
		Point point8 = new Point(6000, 7000);

		target("/point").request().post(Entity.entity(point1, MediaType.APPLICATION_JSON));
		target("/point").request().post(Entity.entity(point2, MediaType.APPLICATION_JSON));
		target("/point").request().post(Entity.entity(point3, MediaType.APPLICATION_JSON));
		target("/point").request().post(Entity.entity(point4, MediaType.APPLICATION_JSON));
		target("/point").request().post(Entity.entity(point5, MediaType.APPLICATION_JSON));
		target("/point").request().post(Entity.entity(point6, MediaType.APPLICATION_JSON));
		target("/point").request().post(Entity.entity(point7, MediaType.APPLICATION_JSON));
		target("/point").request().post(Entity.entity(point8, MediaType.APPLICATION_JSON));

		Response response = target("/lines/4").request().get();
		
		assertEquals("should return status 200", 200, response.getStatus());
		assertEquals(response.readEntity(String.class), "[[{\"x\":10000,\"y\":0},{\"x\":7000,\"y\":3000},{\"x\":3000,\"y\":7000},{\"x\":0,\"y\":10000}]]");
	}

}
