package se.lexicon.g40;

import java.util.Collection;

public class AuthorDAORepository implements AuthorDAO{

    Collection<Author> authorCollection;

    @Override
    public Author findByID(int id) {
        for (Author author:authorCollection) {
            if(author.getAuthorID() == id){
                return author;
            }
        } return null;
    }

    @Override
    public Collection<Author> findAll() {
        return authorCollection;
    }

    @Override
    public Author create(Author author) {
        authorCollection.add(author);
        return author;
    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
