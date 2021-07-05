package exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InventoryNotFoundExceptionHandler implements ExceptionMapper<InventoryNotFoundException> {

    @Override
    public Response toResponse(InventoryNotFoundException exception) {
        return Response.status(400)
                .entity(exception.getMessage())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}