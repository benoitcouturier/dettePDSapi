package trueTest.TU.Product;

import static org.junit.Assert.*;



import javax.ws.rs.core.Response;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;

import DAO.referentiels.produitsVendus.ProductDAO;
import Entites.referentiels.produitsVendus.Product;
import RestGT.referentiels.produitsVendus.ProductApiRest;
import RestGT.referentiels.produitsVendus.ProductService;


public class ProductTest {

	private static final Logger log = Logger.getLogger(ProductApiRest.class);

	public static void init() {
		if(log.getLevel() == null) {
			BasicConfigurator.configure();
			log.setLevel(Level.DEBUG);
		}
	}
	
	
	@Test
	public void testFindProductName() {
		init();
		
		ProductService prodS = new ProductService();
		ProductDAO<Product> pdao = new ProductDAOStub();
		
		// non dispo
		log.info("Test categorie non disponible dans la base");
		String nom="exception";
		Response r = prodS.FindProductName(nom,pdao);
		assertEquals(500,r.getStatus());
		
		
		// erreur
		log.info("Test NON OK");
		nom="OUII";
		r = prodS.FindProductName(nom,pdao);
		assertEquals(201,r.getStatus());
		

		// fonctionne
		log.info("TEST OK");
		nom="OUI";
		r = prodS.FindProductName(nom,pdao);
		assertEquals(200,r.getStatus());
		
	}
}