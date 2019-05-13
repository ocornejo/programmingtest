package programmingtest;

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
import programmingtest.resource.PointResource;

@RunWith(JUnitParamsRunner.class)
public class PointResourceTest extends JerseyTest {

	@Override
	public Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		return new ResourceConfig(PointResource.class);
	}
	
	@Test
	public void testAddPoint() {
		Integer x = 1;
		Integer y = 2;
		Point point = new Point(x, y);
		
		Response output = target("/point").request().post(Entity.entity(point, MediaType.APPLICATION_JSON));

		assertEquals("Should return status 201", 201, output.getStatus());
	}
}
