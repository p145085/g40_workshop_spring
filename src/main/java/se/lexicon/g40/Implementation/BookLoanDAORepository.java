package se.lexicon.g40.Implementation;

import se.lexicon.g40.DAO.BookLoanDAO;
import se.lexicon.g40.model.Book;
import se.lexicon.g40.model.BookLoan;

import javax.persistence.EntityManager;
import java.util.Collection;

public class BookLoanDAORepository implements BookLoanDAO {
    EntityManager entityManager;
    @Override
    public BookLoan findByID(int id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Override
    public Collection<BookLoan> findAll() {
        return entityManager.createQuery("SELECT * FROM book_loan", BookLoan.class).getResultList();
    }

    @Override
    public BookLoan create(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findByID(id));
    }
}
