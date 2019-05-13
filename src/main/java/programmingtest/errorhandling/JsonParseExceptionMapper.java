package programmingtest.errorhandling;

import javax.annotation.Priority;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.JsonMappingException;

@Provider
@Priority(1)
public class JsonParseExceptionMapper extends Exception implements ExceptionMapper<JsonMappingException> {

	private static final long serialVersionUID = 1L;
	
	@Override
	public Response toResponse(JsonMappingException ex) {
		 return Response.status(Response.Status.BAD_REQUEST)
	                .entity(new ErrorMessage(new AppException(ex.getMessage(), 400)))
	                .type(MediaType.APPLICATION_JSON)
	                .build();
	}
   
}
