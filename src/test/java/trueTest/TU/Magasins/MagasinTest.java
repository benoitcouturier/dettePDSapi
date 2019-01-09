package trueTest.TU.Magasins;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

import DAO.referentiels.magasins.MagasinsDAO;
import Entites.referentiels.magasins.Magasin;
import RestGT.referentiels.magasins.CallMagasin;
import RestGT.referentiels.magasins.CallMagasinImpl;
import RestGT.referentiels.magasins.MagasinApiRest;
import RestGT.referentiels.magasins.MagasinService;


public class MagasinTest {

	private static final Logger log = Logger.getLogger(MagasinApiRest.class);

	public static void init() {
		if(log.getLevel() == null) {
			BasicConfigurator.configure();
			log.setLevel(Level.DEBUG);
		}
	}
	
	@Test
	public void testRechercheType() {
		init();
		
		MagasinService magCon = new MagasinService();
		MagasinsDAO<Magasin> dao = new MagasinDAOStub();
		
		// Pas cette catégorie dans la base
		log.info("Test categorie non disponible dans la base");
		int id=0;
		Response r = magCon.rechercherMagasinType(id,dao);
		assertEquals(202,r.getStatus());
		
		
		// Pas de résultat
		log.info("Test pas de resultats dans la base");
		id=6;
		r = magCon.rechercherMagasinType(id,dao);
		assertEquals(201,r.getStatus());
		

		// Tout ok
		log.info("Test tout est OK");
		id=8;
		r = magCon.rechercherMagasinType(id,dao);
		assertEquals(200,r.getStatus());
		
		log.info("Test tout est OK");
		id=9;
		r = magCon.rechercherMagasinType(id,dao);
		assertEquals(500,r.getStatus());
		
	}
	
	@Test
	public void testRechercheNom() {
		init();
		
		MagasinService magCon = new MagasinService();
		MagasinsDAO<Magasin> dao = new MagasinDAOStub();
		
		// Pas cette catégorie dans la base
		log.info("Test categorie non disponible dans la base");
		String nom="exception";
		Response r = magCon.rechercherMagasinNom(nom,dao);
		assertEquals(500,r.getStatus());
		
		
		// Pas de résultat
		log.info("Test pas de resultats dans la base");
		nom="non";
		r = magCon.rechercherMagasinNom(nom,dao);
		assertEquals(201,r.getStatus());
		

		// Tout ok
		log.info("Test tout est OK");
		nom="oui";
		r = magCon.rechercherMagasinNom(nom,dao);
		assertEquals(200,r.getStatus());
		
	}
}
