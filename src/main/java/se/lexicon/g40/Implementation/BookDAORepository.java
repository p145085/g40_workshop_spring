package se.lexicon.g40.Implementation;

import se.lexicon.g40.DAO.BookDAO;
import se.lexicon.g40.model.Author;
import se.lexicon.g40.model.Book;

import javax.persistence.EntityManager;
import java.util.Collection;

public class BookDAORepository implements BookDAO {
    EntityManager entityManager;
    @Override
    public Book findByID(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public Collection<Book> findAll() {
        return entityManager.createQuery("SELECT * FROM book", Book.class).getResultList();
    }

    @Override
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findByID(id));
    }
}
