package entity;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
@NamedQueries({
        @NamedQuery(name = "entity.inventory.findAll", query = "select e from Inventory e"),
        @NamedQuery(name = "entity.inventory.update",
                query = "update Inventory e set e.quantity=:quantity where e.id=:id"),
        @NamedQuery(name= "entity.inventory.delete", query = "delete from Inventory e where e.id=:id"),
        @NamedQuery(name = "entity.inventory.findByBookId", query = "select e from Inventory e where e.bookDetails.id = :id")
})
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne
    @JoinColumn(name="book_details_id", referencedColumnName = "id")
    BookDetails bookDetails;
    @Column(name = "quantity")
    long quantity;


    public Inventory() {
    }

    public Inventory(BookDetails bookDetails, long quantity) {
        this.bookDetails = bookDetails;
        this.quantity = quantity;
    }

    public Inventory(long id, BookDetails bookDetailsId, long quantity) {
        this.id = id;
        this.bookDetails = bookDetailsId;
        this.quantity = quantity;
    }

    public Inventory(long id, long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BookDetails getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetails bookDetails) {
        this.bookDetails = bookDetails;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
