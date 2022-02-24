package se.lexicon.g40;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

import static se.lexicon.g40.EntityConstants.GENERATOR;
import static se.lexicon.g40.EntityConstants.UUID_GENERATOR;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int authorID;

    private String firstName;
    private String lastName;

    @ManyToMany(
            cascade = {CascadeType.REFRESH,CascadeType.DETACH},
            fetch = FetchType.LAZY
    )
    private Set<Book> writtenBooks;

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getWrittenBooks() {
        return writtenBooks;
    }

    public void setWrittenBooks(Set<Book> writtenBooks) {
        this.writtenBooks = writtenBooks;
    }
}
