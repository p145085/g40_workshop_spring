package se.lexicon.g40.Implementation;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g40.DAO.AppUserDAO;
import se.lexicon.g40.model.AppUser;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
@Transactional
public class AppUserDAORepository implements AppUserDAO {

    EntityManager entityManager;

    @Override
    public AppUser findByID(int id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("SELECT a FROM app_user a", AppUser.class).getResultList();
    }

    @Override
    public AppUser create(AppUser appUser) {
        entityManager.persist(appUser);
        return appUser;
    }

    @Override
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findByID(id));
    }
}
