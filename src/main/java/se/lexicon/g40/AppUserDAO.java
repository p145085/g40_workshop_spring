package se.lexicon.g40;

import java.util.Collection;

public interface AppUserDAO {
    AppUser findByID(int id);
    Collection<AppUser> findAll();
    AppUser create(AppUser appUser);
    AppUser update(AppUser appUser);
    void delete(int id);
}
