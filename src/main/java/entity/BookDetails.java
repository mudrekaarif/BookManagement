package entity;

import javax.persistence.*;

@Entity
@Table(name="book_details")
@NamedQueries({
        @NamedQuery(name = "entity.bookDetails.findAll", query = "select e from BookDetails e"),
        @NamedQuery(name = "entity.bookDetails.findById", query = "select e from BookDetails e where e.id=:id"),
        @NamedQuery(name = "entity.bookDetails.update" , query = "update BookDetails e set e.title=:title , e.author=:author where e.id=:id"),
        @NamedQuery(name = "entity.bookDetails.delete" , query = "delete from BookDetails e where e.id=:ID"),
        @NamedQuery(name = "entity.bookDetails.countByAuthor", query = "select count(id) from BookDetails e where e.author=:author")
})
public class BookDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    String title;
    @Column(name = "author")
    String author;

    public BookDetails() {
    }

    public BookDetails(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public BookDetails(long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
