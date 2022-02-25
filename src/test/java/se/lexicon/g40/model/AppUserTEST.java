package se.lexicon.g40.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g40.DAO.AppUserDAO;
import se.lexicon.g40.DAO.DetailsDAO;
import se.lexicon.g40.model.AppUser;
import se.lexicon.g40.model.Details;

import java.time.LocalDate;
import java.util.Collection;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext
public class AppUserTEST {
    public static final int appUserID = 1;
    public static final String username = "Emil";
    public static final String password = "TrasanBanan";
    public static final LocalDate regDate = LocalDate.of(1992,2,12);
    public static final Details userDetails = new Details();
    AppUser appUser = new AppUser();

    @BeforeEach
    void setUp() {

    }

    @Test
    void findByID() {
//        return appUser.getAppUserID();
    }

}
