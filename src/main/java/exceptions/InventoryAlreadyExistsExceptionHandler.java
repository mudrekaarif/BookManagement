package exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InventoryAlreadyExistsExceptionHandler implements ExceptionMapper<InventoryAlreadyExistsException> {

    @Override
    public Response toResponse(InventoryAlreadyExistsException exception) {
        return Response.status(400)
                .entity(exception.getMessage())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}