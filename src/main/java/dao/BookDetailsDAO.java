package dao;

import entity.BookDetails;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDetailsDAO extends AbstractDAO<BookDetails> {
    public BookDetailsDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<BookDetails> findAll() {
        return list(namedQuery("entity.bookDetails.findAll"));
    }

    public BookDetails findById(long id) {
        return get(id);
//        return namedQuery("entity.bookDetails.findById").setParameter("id",id).uniqueResult();
    }

    public BookDetails create(BookDetails bookDetails) {
        return persist(bookDetails);
    }

    public void update(BookDetails bookDetails) {
         namedQuery("entity.bookDetails.update") // update BookDetails e set e.title=:title , e.author=:author where e.id=:id
                .setParameter("title", bookDetails.getTitle())
                .setParameter("id", bookDetails.getId())
                 .setParameter("author", bookDetails.getAuthor())
                 .executeUpdate();
    }

    public void delete(long id) {
        namedQuery("entity.bookDetails.delete")
                .setParameter("ID", id).executeUpdate();
    }

    public long countBooksByAuthor(String author) {
        return (long) namedQuery("entity.bookDetails.countByAuthor")
                .setParameter("author", author).uniqueResult();
    }
}
