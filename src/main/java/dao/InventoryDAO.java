package dao;

import entity.Inventory;
import entity.Test;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class InventoryDAO extends AbstractDAO<Inventory> {
    public InventoryDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Inventory> findAll() {
        return list(namedQuery("entity.inventory.findAll"));
    }

    public Inventory findById(long id) {
        return get(id);
    }

    public Inventory findByBookId(long bookId) {
        return (Inventory) namedQuery("entity.inventory.findByBookId")
                .setParameter("id",bookId).uniqueResult();
    }

    public Inventory create(Inventory inventory) {
        return persist(inventory);
    }

    public Inventory update(Inventory inventory) {
        namedQuery("entity.inventory.update")
                .setParameter("id", inventory.getId())
                .setParameter("quantity", inventory.getQuantity())
                .executeUpdate();
        return findById(inventory.getId());
    }

    public void delete(long id) {
        namedQuery("entity.inventory.delete")
                .setParameter("id", id).executeUpdate();
    }
}
