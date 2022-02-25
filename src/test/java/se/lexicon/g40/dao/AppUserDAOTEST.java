package se.lexicon.g40.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g40.Implementation.AppUserDAORepository;
import se.lexicon.g40.model.AppUser;
import se.lexicon.g40.model.Details;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext
public class AppUserDAOTEST {

    @Autowired
    AppUserDAORepository testObject;

    @Autowired
    TestEntityManager entityManager;

    public List<AppUser> appUserList(){
        return Arrays.asList(
                new AppUser(1, "Emil", "password1", LocalDate.of(2010,1,1), new Details(1, "bla1@bla.bla", "blah", LocalDate.of(2000,1,1))),
                new AppUser(1, "Darwin", "password2", LocalDate.of(2011,1,1), new Details(1, "bla2@bla.bla", "blah", LocalDate.of(2001,1,1))),
                new AppUser(1, "EmilDarwin", "password3", LocalDate.of(2012,1,1), new Details(1, "bla3@bla.bla", "blah", LocalDate.of(2002,1,1)))
        );
    }
    private List<AppUser> persistedAppUsers;

    @BeforeEach
    void setUp() {
        persistedAppUsers = appUserList().stream()
                .map(entityManager::persist)
                .collect(Collectors.toList());
    }

    @Test
    void save() {
        AppUser appUser = new AppUser(1,
                "Emil",
                "password1",
                LocalDate.of(2010,1,1),
                new Details(1, "bla1@bla.bla", "blah", LocalDate.of(2000,1,1))
        );

        AppUser result = testObject.create(appUser);
        assertNotNull(result);
    }


}
