package se.lexicon.g40.Implementation;

import se.lexicon.g40.DAO.AuthorDAO;
import se.lexicon.g40.model.AppUser;
import se.lexicon.g40.model.Author;

import javax.persistence.EntityManager;
import java.util.Collection;

public class AuthorDAORepository implements AuthorDAO {

    EntityManager entityManager;

    @Override
    public Author findByID(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("SELECT * FROM author", Author.class).getResultList();
    }

    @Override
    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public Author update(Author author) {
        return entityManager.merge(author);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findByID(id));
    }
}
