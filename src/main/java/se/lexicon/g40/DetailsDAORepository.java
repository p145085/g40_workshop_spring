package se.lexicon.g40;

import java.util.Collection;

public class DetailsDAORepository implements DetailsDAO{

    Collection<Details> detailsCollection;

    @Override
    public Details findByID(int id) {
        for (Details details:detailsCollection) {
            if (details.getDetailsID() == id){
                return details;
            }
        }
        return null;
    }

    @Override
    public Collection<Details> findAll() {
        return detailsCollection;
    }

    @Override
    public Details create(Details details) {
        detailsCollection.add(details);
        return details;
    }

    @Override
    public Details update(Details details) {
        return null;
    }

    @Override
    public void delete(int id) {
        detailsCollection.remove(findByID(id));
    }
}
