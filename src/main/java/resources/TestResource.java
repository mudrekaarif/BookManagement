package resources;

import dao.TestDAO;
import entity.Test;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestResource {
    private TestDAO testDAO;
    public TestResource(TestDAO testDAO) {
        this.testDAO = testDAO;
    }

    @GET
    @UnitOfWork
    public List<Test> test() {
        return testDAO.findAll();
    }
}
