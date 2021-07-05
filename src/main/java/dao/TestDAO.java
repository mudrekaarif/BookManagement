package dao;

import entity.Test;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class TestDAO extends AbstractDAO<Test> {
    public TestDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Test> findAll() {
        return list(namedQuery("entity.test.findAll"));
    }
}
