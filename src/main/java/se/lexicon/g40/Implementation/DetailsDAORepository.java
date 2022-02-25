package se.lexicon.g40.Implementation;

import se.lexicon.g40.DAO.DetailsDAO;
import se.lexicon.g40.model.BookLoan;
import se.lexicon.g40.model.Details;

import javax.persistence.EntityManager;
import java.util.Collection;

public class DetailsDAORepository implements DetailsDAO {

    EntityManager entityManager;

    @Override
    public Details findByID(int id) {
        return entityManager.find(Details.class, id);
    }

    @Override
    public Collection<Details> findAll() {
        return entityManager.createQuery("SELECT * FROM details", Details.class).getResultList();
    }

    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return details;
    }

    @Override
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findByID(id));
    }
}
