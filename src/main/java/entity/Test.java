package entity;

import javax.persistence.*;

@Entity
@Table(name = "test")
@NamedQueries({
        @NamedQuery(name = "entity.test.findAll", query = "select e from Test e")
})
public class Test {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "text")
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
