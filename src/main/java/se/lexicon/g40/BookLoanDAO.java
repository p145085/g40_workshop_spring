package se.lexicon.g40;

import java.util.Collection;

public interface BookLoanDAO {
    BookLoan findByID(int id);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(int id);
}
