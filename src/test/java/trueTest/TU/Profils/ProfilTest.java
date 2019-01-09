package trueTest.TU.Profils;


import DAO.referentiels.profilsConsommateur.ProfilDAO;
import Entites.referentiels.profilsConsommateur.Profil;
import RestGT.referentiels.profils.ProfilService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class ProfilTest {


    private static final Logger log = Logger.getLogger(ProfilTest.class);

    public static void init() {
        if (log.getLevel() == null) {
            BasicConfigurator.configure();
            log.setLevel(Level.DEBUG);
        }
    }

    @Test
    public void createProfil() {
        init();

        ProfilService pro = new ProfilService();
        ProfilDAO<Profil> dao = new ProfilDAOStub();
        Profil profil = new Profil();

        profil.setAgeClient(1);
        Response r = pro.create(profil, dao);
        assertEquals(501, r.getStatus());


        log.info("Test erreur dans la base");
        profil.setProfilT_id(1);
        profil.setProfilT_name("Profil de test");
        profil.setSexClient("Femme");
        profil.setPurchaseVolume(50);
        profil.setAgeClient(1);
        r = pro.create(profil, dao);
        assertEquals(500, r.getStatus());

        profil.setAgeClient(18);
        r = pro.create(profil, dao);
        assertEquals(200, r.getStatus());


    }

}
