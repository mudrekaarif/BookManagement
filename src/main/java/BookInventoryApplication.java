import config.BaseConfiguration;
import dao.BookDetailsDAO;
import dao.InventoryDAO;
import dao.TestDAO;
import entity.BookDetails;
import entity.Inventory;
import entity.Test;
import exceptions.BookNotFoundExceptionHandler;
import exceptions.InventoryAlreadyExistsExceptionHandler;
import exceptions.InventoryNotFoundExceptionHandler;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resources.BookDetailsResource;
import resources.InventoryResource;
import resources.TestResource;
import service.BookServiceImpl;
import service.InventoryServiceImpl;

public class BookInventoryApplication extends Application<BaseConfiguration> {

    public static void main(String[] args) throws Exception {
        new BookInventoryApplication().run(args);
    }

    private final HibernateBundle<BaseConfiguration> hibernate = new HibernateBundle<BaseConfiguration>(Test.class, BookDetails.class, Inventory.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(BaseConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(Bootstrap<BaseConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(BaseConfiguration baseConfiguration, Environment environment) throws Exception {
        TestDAO testDAO = new TestDAO(hibernate.getSessionFactory());
        final TestResource testResource = new TestResource(testDAO);
        environment.jersey().register(testResource);

        BookDetailsDAO bookDetailsDAO = new BookDetailsDAO(hibernate.getSessionFactory());
        final BookDetailsResource bookDetailsResource = new BookDetailsResource(new BookServiceImpl(bookDetailsDAO));
        environment.jersey().register(bookDetailsResource);

        InventoryDAO inventoryDAO = new InventoryDAO(hibernate.getSessionFactory());
        final InventoryResource inventoryResource= new InventoryResource(new InventoryServiceImpl(inventoryDAO, bookDetailsDAO));
        environment.jersey().register(inventoryResource);

        environment.jersey().register(new BookNotFoundExceptionHandler());
        environment.jersey().register(new InventoryNotFoundExceptionHandler());
        environment.jersey().register(new InventoryAlreadyExistsExceptionHandler());

    }
}
