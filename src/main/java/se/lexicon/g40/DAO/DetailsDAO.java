package se.lexicon.g40.DAO;

import se.lexicon.g40.model.Details;

import java.util.Collection;

public interface DetailsDAO {
    Details findByID(int id);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(int id);
}
