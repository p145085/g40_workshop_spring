package se.lexicon.g40;

import java.util.Collection;

public interface BookDAO {
    Book findByID(int id);
    Collection<Book> findAll();
    Book create(Book book);
    Book update(Book book);
    void delete(int id);
}
