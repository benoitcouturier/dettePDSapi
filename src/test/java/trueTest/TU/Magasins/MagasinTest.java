package trueTest.TU.Magasins;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import DAO.referentiels.magasins.MagasinDAOImpl;
import DAO.referentiels.magasins.MagasinsDAO;
import Entites.referentiels.magasins.Magasin;

public class MagasinTest {

	
	@Test
	public void test() {
		MagasinsDAO<Magasin> mDao = new MagasinDAOImpl();
		ArrayList<Magasin> array = new ArrayList<Magasin>();
		
		try {
			array = mDao.read();
			
			Magasin m = new Magasin();
			m.setIdEmplacement(150);
			m.setIdType(1);
			m.setDescription("Test");
			m.setNom("Test");
			
			mDao.create(m);
			
			m = mDao.selectMax();
			assertEquals(mDao.read().size(),array.size()+1);
			
			mDao.delete(m);
		
			assertEquals(mDao.read().size(),array.size());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
			
		}
		
		try {

			Magasin m = new Magasin();
			m.setIdType(1);
			array = mDao.rechercheType(m);
			
			for(Magasin mag : array) {
				assertEquals(1,mag.getIdType());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
			
		}
		
	}
}
