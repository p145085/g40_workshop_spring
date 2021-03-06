package se.lexicon.g40.DAO;

import se.lexicon.g40.model.Author;

import java.util.Collection;

public interface AuthorDAO {
    Author findByID(int id);
    Collection<Author> findAll();
    Author create(Author author);
    Author update(Author author);
    void delete(int id);
}
