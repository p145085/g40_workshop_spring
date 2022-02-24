package se.lexicon.g40;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

public class AppUserDAORepository implements AppUserDAO{

    Collection<AppUser> appUserCollection;

    EntityManager entityManager;

    @Override
    public AppUser findByID(int id) {
        for (AppUser appUser:appUserCollection) {
            if (appUser.getAppUserID() == id){
                return appUser;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("SELECT * FROM appuser", AppUser.class).getResultList();
    }

    @Override
    public AppUser create(AppUser appUser) {
        appUserCollection.add(appUser);
        return appUser;
    }

    @Override
    public AppUser update(AppUser appUser) {
        return null;
    }

    @Override
    public void delete(int id) {
        appUserCollection.remove(findByID(id));
    }
}
